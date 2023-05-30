//package com.eindopdracht.BE.ReneWeerts.Controller;
//
//import com.eindopdracht.BE.ReneWeerts.Owner;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@RequestMapping("/owners")
//public class OwnerController {
//    private final List<Owner> owners = new ArrayList<>();
//
//    @PostMapping
//    public ResponseEntity<Owner> createOwner(@RequestBody Owner o) {
//        owners.add(o);
//        return new ResponseEntity<>(o, HttpStatus.CREATED);
//    }
//    @GetMapping
//    public ResponseEntity<List <Owner>> getOwner () {
//        return new ResponseEntity<>(owners, HttpStatus.OK);
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<List<Owner>> getOwnerById (@PathVariable int id) {
//        if (id > 0 && id < owners.size()) {
//            return new ResponseEntity<>(owners, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//    }
//    @PutMapping("/{id}")
//    public ResponseEntity<List<Owner>> updateOwnerById (@RequestBody Owner o,@PathVariable int id) {
//        if (id >= 0 && id < owners.size()) { // ID groter of gelijk aan nul, ID kleiner dan grote van lijst (-2,-3)
//            owners.set(id, o); // .set hiermee update je de arrayList van persons, geef (int) index mee en person element.
//            return new ResponseEntity<>(owners, HttpStatus.OK);
//        } else {
//            //error situation
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//    }
//   @DeleteMapping("/{id}")
//    public ResponseEntity<HttpStatus> deleteOwner (@PathVariable int id) {
//       if (id > 0 && id < owners.size()) {
//           owners.remove(id);
//           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//       } else {
//           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//       }
//   }
//
//
//
//
//}
