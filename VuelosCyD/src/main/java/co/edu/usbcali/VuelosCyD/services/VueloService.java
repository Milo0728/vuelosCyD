package co.edu.usbcali.VuelosCyD.services;

import java.util.List;

import co.edu.usbcali.VuelosCyD.dtos.VueloDTO;

public interface VueloService {

    VueloDTO guardarVuelo(VueloDTO vueloDTO) throws Exception;
    VueloDTO obtenerVuelo();
    List<VueloDTO> obtenerVuelos(); 

}
