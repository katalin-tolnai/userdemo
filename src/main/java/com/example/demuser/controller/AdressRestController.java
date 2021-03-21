package com.example.demuser.controller;

import com.example.demuser.entity.Adress;
import com.example.demuser.repository.AdressRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adress")
public class AdressRestController {

    private final AdressRepository adressRepository;

    public AdressRestController(AdressRepository adressRepository) {
        this.adressRepository = adressRepository;
    }

    @GetMapping
    public List<Adress> getAll() {

        return (List<Adress>) adressRepository.findAll();
    }

    @GetMapping("/{id}")
    public Adress getById(@PathVariable String id) {
        return adressRepository.findById(id).orElseThrow(() -> new AdressNotFounfException("No adress with id: " + id));
    }

    @PostMapping
    public Adress save(@RequestBody Adress adress) {
        return adressRepository.save(adress);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        Adress adress = adressRepository.findById(id).orElseThrow(() -> new AdressNotFounfException(id));
        adressRepository.delete(adress);
    }

    @PutMapping
    public Adress modify(@RequestBody Adress modifedAdress) {
        return adressRepository.findById(modifedAdress.getId()).map(adress -> modifyProperties(modifedAdress, adress)).orElse(adressRepository.save(modifedAdress));
    }

    private Adress modifyProperties(Adress modifedAdress, Adress adress) {
        adress.setCity(modifedAdress.getCity());
        adress.setApartmentNr(modifedAdress.getApartmentNr());
        adress.setHouseNr(modifedAdress.getHouseNr());
        adress.setStreet(modifedAdress.getStreet());
        adress.setCity(modifedAdress.getCity());
        adress.setZipCode(modifedAdress.getZipCode());
        return adressRepository.save(adress);
    }


}
