package com.oms.studentcrud.controller;
import com.oms.studentcrud.entities.request.StudentRequest;
import com.oms.studentcrud.entities.response.EntityResponse;
import com.oms.studentcrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/student")
public class StudentController
{
    @Autowired
    private StudentService studentService;
    @PostMapping("/saveOrupdateStudent")
    public ResponseEntity<?> saveOrUpdateStudent(@RequestBody StudentRequest studentRequest){
        try
        {
            return new ResponseEntity<>(new EntityResponse(studentService.saveOrUpdateStudent(studentRequest),0), HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(new EntityResponse(e.getMessage(),-1), HttpStatus.OK);
        }
    }
    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam Long studentId)
    {
        try{
            return new ResponseEntity<>(new EntityResponse(studentService.getById(studentId),0),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new EntityResponse(e.getMessage(),-1),HttpStatus.OK);
        }
    }
    @GetMapping("/getAllStudent")
    public ResponseEntity<?> getAllStudent()
    {
        try{
            return new ResponseEntity<>(new EntityResponse(studentService.getAllStudent(),0),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new EntityResponse(e.getMessage(),-1),HttpStatus.OK);
        }
    }
    @DeleteMapping("/deleteById")
    public ResponseEntity<?> deleteById(@RequestParam Long studentId)
    {
        try{
            return new ResponseEntity<>(new EntityResponse(studentService.deleteById(studentId),0),HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<>(new EntityResponse(e.getMessage(),-1),HttpStatus.OK);
        }
    }
    @PutMapping("/changeStatus")
    public ResponseEntity<?> changeStatus(@RequestParam Long studentId)
    {
        try{
            return new ResponseEntity<>(new EntityResponse(studentService.chnageStatus(studentId),0),HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<>(new EntityResponse(e.getMessage(),-1),HttpStatus.OK);
        }
    }

}
