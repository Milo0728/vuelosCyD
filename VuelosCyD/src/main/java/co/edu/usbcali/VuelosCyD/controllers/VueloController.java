package co.edu.usbcali.VuelosCyD.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.VuelosCyD.dtos.MensajeDTO;
import co.edu.usbcali.VuelosCyD.dtos.VueloDTO;
import co.edu.usbcali.VuelosCyD.services.VueloService;

@RestController
@RequestMapping("/vuelo")
public class VueloController {
    
    private VueloService vueloService;

    public VueloController(VueloService vueloService) { this.vueloService = vueloService; }

    @GetMapping("/obtenerVuelo")
    public ResponseEntity<VueloDTO> obtenerVuelo() {
        return new ResponseEntity(vueloService.obtenerVuelo(), HttpStatus.OK);
    }

    @GetMapping("/obtenerVuelos")
    public ResponseEntity<List<VueloDTO>> obtenerVuelos() {
        return new ResponseEntity(vueloService.obtenerVuelos(), HttpStatus.OK);
    }

    @PostMapping(
        path = "/guardarVuelo",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity guardarVuelo(@RequestBody VueloDTO vueloDTO) {
        try {
            return new ResponseEntity(vueloService.guardarVuelo(vueloDTO), HttpStatus.OK);
        } catch ( Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

}
