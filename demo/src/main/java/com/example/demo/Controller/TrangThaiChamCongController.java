package com.example.demo.Controller;

import com.example.demo.Entity.TrangThaiChamCongEntity;
import com.example.demo.Service.TrangThaiChamCongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (value = "/api/trangthaichamcong")
public class TrangThaiChamCongController {
    @Autowired
    private TrangThaiChamCongService trangThaiChamCongService;

    @CrossOrigin("http://localhost:3000")
    @GetMapping("")
    public List<TrangThaiChamCongEntity> getAll ()
    {
        return trangThaiChamCongService.GetAllActive();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<TrangThaiChamCongEntity> getById (@PathVariable Long id)
    {
        Optional<TrangThaiChamCongEntity> e = trangThaiChamCongService.FindById (id);
        return e.map (trangThaiChamCongEntity -> new ResponseEntity<> (trangThaiChamCongEntity, HttpStatus.OK)).orElseGet (() -> new ResponseEntity<> (HttpStatus.NOT_FOUND));
    }

    public TrangThaiChamCongEntity getTrangThaiChamCongById (Long id){
        Optional<TrangThaiChamCongEntity> ttcc = trangThaiChamCongService.FindById (id);
        return ttcc.get ();
    }

    @PostMapping("")
    public ResponseEntity<TrangThaiChamCongEntity> insert (@RequestBody TrangThaiChamCongEntity trangThaiChamCongEntity)
    {
        Long id = trangThaiChamCongService.Insert (trangThaiChamCongEntity).getTrangThaiChamCongId ();
        Optional<TrangThaiChamCongEntity> e = trangThaiChamCongService.FindById (id);
//        System.out.println(e);
//        System.out.println (e.map (trangThaiChamCongEntity1 -> new ResponseEntity<> (trangThaiChamCongEntity1, HttpStatus.OK)));
        return e.map (trangThaiChamCongEntity1 -> new ResponseEntity<> (trangThaiChamCongEntity1, HttpStatus.OK)).orElseGet (() -> new ResponseEntity<> (HttpStatus.NOT_ACCEPTABLE));
    }

    //
    @PutMapping ("/{id}")
    public ResponseEntity<TrangThaiChamCongEntity> update (@PathVariable Long id, @RequestBody TrangThaiChamCongEntity trangThaiChamCongEntity)
    {
        Optional<TrangThaiChamCongEntity> e = trangThaiChamCongService.FindById (id);
        if (e.isPresent ())
        {
            trangThaiChamCongEntity.setTrangThaiChamCongId (id);
            return new ResponseEntity<> (trangThaiChamCongService.Update (trangThaiChamCongEntity), HttpStatus.OK);
        }
        return new ResponseEntity<> (HttpStatus.NOT_FOUND);
    }

    @PutMapping ("/remove/{id}")
    public ResponseEntity<TrangThaiChamCongEntity> remove (@PathVariable Long id, @RequestBody TrangThaiChamCongEntity trangThaiChamCongEntity)
    {
        Optional<TrangThaiChamCongEntity> e = trangThaiChamCongService.FindById (id);
        if (e.isPresent ())
        {
            trangThaiChamCongEntity.setTrangThaiChamCongId (id);
            trangThaiChamCongEntity.setStatus (0);
            return new ResponseEntity<> (trangThaiChamCongService.Update (trangThaiChamCongEntity), HttpStatus.OK);
        }
        return new ResponseEntity<> (HttpStatus.NOT_FOUND);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<TrangThaiChamCongEntity> delete (@PathVariable Long id)
    {
        Optional<TrangThaiChamCongEntity> e = trangThaiChamCongService.FindById (id);
        if (e.isPresent ())
        {
            trangThaiChamCongService.Delete (id);
            return new ResponseEntity<> (HttpStatus.OK);
        }
        return new ResponseEntity<> (HttpStatus.NOT_FOUND);
    }
}
