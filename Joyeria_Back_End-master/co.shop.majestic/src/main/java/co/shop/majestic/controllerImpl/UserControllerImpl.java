package co.shop.majestic.controllerImpl;

import co.shop.majestic.constant.JoyeriaConstant;
import co.shop.majestic.controller.UserController;
import co.shop.majestic.service.UserService;
import co.shop.majestic.utils.JoyeriaUtils;
import co.shop.majestic.wrapper.UserWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    UserService userService;

    @Override
    public ResponseEntity<String> singUp(Map<String, String> requestMap) {
        try{
            return userService.signUp(requestMap);
        }catch (Exception ex){
            ex.printStackTrace();

        }
        return JoyeriaUtils.getResponseEntity(JoyeriaConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> login(Map<String, String> requestMap) {
        try{
            return userService.login(requestMap);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  JoyeriaUtils.getResponseEntity(JoyeriaConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<UserWrapper>> getAllUser() {
        try{
            return userService.getAllUser();
        }catch (Exception ex ){
            ex.printStackTrace();
        }
        return new ResponseEntity<List<UserWrapper>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @Override
    public ResponseEntity<String> update(Map<String, String> requestMap) {
        try{
            return userService.update(requestMap);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return JoyeriaUtils.getResponseEntity(JoyeriaConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> checkToken() {
        try{
            return userService.checkToken();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return JoyeriaUtils.getResponseEntity(JoyeriaConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> changePassword(Map<String, String> requestMap) {
        try{
            return userService.changePassword(requestMap);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return JoyeriaUtils.getResponseEntity(JoyeriaConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}