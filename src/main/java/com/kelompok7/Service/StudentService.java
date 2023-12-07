package com.kelompok7.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;


import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firestore.v1.WriteResult;
import com.kelompok7.Model.Student;

@Service
public class StudentService {
    
    private static final String COLLECTION_NAME = "students";

    public String saveStudent(Student student) throws InterruptedException, ExecutionException{

        Firestore dbFirestore= FirestoreClient.getFirestore();
        ApiFuture<com.google.cloud.firestore.WriteResult> collectionApiFuture=dbFirestore.collection(COLLECTION_NAME).document(student.getName()).set(student);
        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public Student getStudent(String name) throws InterruptedException, ExecutionException{
        Firestore dbFirestore= FirestoreClient.getFirestore();
        DocumentReference documentReference=dbFirestore.collection(COLLECTION_NAME).document(name);
        ApiFuture<DocumentSnapshot> future=documentReference.get();
        DocumentSnapshot document=future.get();


        Student student = null;
        if(document.exists()){
            student = document.toObject(Student.class);
            return student;
        }else{
            return null;
        }
    }

    public String updateStudent(Student student) throws InterruptedException, ExecutionException{

        Firestore dbFirestore= FirestoreClient.getFirestore();
        ApiFuture<com.google.cloud.firestore.WriteResult> collectionApiFuture=dbFirestore.collection(COLLECTION_NAME).document(student.getName()).set(student);
        return collectionApiFuture.get().getUpdateTime().toString();
    }

     public String deleteStudent(String name) throws InterruptedException, ExecutionException{

        Firestore dbFirestore= FirestoreClient.getFirestore();
        ApiFuture<com.google.cloud.firestore.WriteResult> collectionApiFuture=dbFirestore.collection(COLLECTION_NAME).document(name).delete();
        return "Student with name "+name+" has been deleted successfully";
    }

    public List<Student> getStudentall() throws InterruptedException, ExecutionException{
        Firestore dbFirestore= FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReference=dbFirestore.collection(COLLECTION_NAME).listDocuments();
        Iterator<DocumentReference> iterator=documentReference.iterator();

        List<Student> studentList= new ArrayList<>();
        Student student=null;

        while(iterator.hasNext()){
            DocumentReference documentReference1=iterator.next();
            ApiFuture<DocumentSnapshot> future= documentReference1.get();
            DocumentSnapshot document=future.get();

            student=document.toObject(Student.class);
            studentList.add(student);
        }
        return studentList;
    }
}
