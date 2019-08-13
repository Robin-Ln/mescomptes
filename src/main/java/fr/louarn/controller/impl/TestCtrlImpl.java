package fr.louarn.controller.impl;

import fr.louarn.controller.ITestCtrl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestCtrlImpl implements ITestCtrl {

    @Override
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

}
