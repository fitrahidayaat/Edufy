// package com.kelompok7.restTmpl;

// import java.util.Map;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatusCode;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.RestController;

// import com.kelompok7.Constantce.EdufyConstance;
// import com.kelompok7.rest.UserRest;
// import com.kelompok7.service.UserService;
// import com.kelompok7.utils.EdufyUtils;


// @RestController
// public class UserRestTmpl implements UserRest {

//     @Autowired
//     UserService UserService;


//     @Override
//     public ResponseEntity<String> signUp(Map<String, String> requestMap) {
//         try{
//             return UserService.signUp(requestMap);
//         }catch(Exception ex){
//             ex.printStackTrace();
//         }
//         return EdufyUtils.getResponseEntity(EdufyConstance.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
//     }
    
// }
