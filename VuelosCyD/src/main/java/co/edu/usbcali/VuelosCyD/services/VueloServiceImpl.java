package co.edu.usbcali.VuelosCyD.services;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.usbcali.VuelosCyD.dtos.VueloDTO;

@Service
public class VueloServiceImpl implements VueloService {

    @Override
    public VueloDTO guardarVuelo(VueloDTO vueloDTO) throws Exception {
        if (vueloDTO == null) {
            throw new Exception("El Vuelo viene con datos nulos");
        }
        if (vueloDTO.getId() == null || vueloDTO.getId().trim().equals("")) {
            throw new Exception("Id nulo");
        }
        if (vueloDTO.getOrigen() == null || vueloDTO.getOrigen().trim().equals("")) {
            throw new Exception("Origen nulo");
        }
        if (vueloDTO.getDestino() == null || vueloDTO.getDestino().trim().equals("")) {
            throw new Exception("Destino nulo");
        }
        if (vueloDTO.getIdAvion() == null || vueloDTO.getIdAvion().trim().equals("")) {
            throw new Exception("idAvion nulo");
        }

        return vueloDTO;

    }

    @Override
    public VueloDTO obtenerVuelo() {
        // TODO Auto-generated method stub
        return VueloDTO.builder()
            .origen("Cali")
            .destino("Buenaventura")
            .fechaHoraSalida(new Date())
            .fechaHoraLlegada(new Date())
            .id("12345").idAvion("54321").build();
    }

    @Override
    public List<VueloDTO> obtenerVuelos() {
        // TODO Auto-generated method stub
        return Arrays.asList(
            VueloDTO.builder()
                    .origen("Cali")
                    .destino("Buenaventura")
                    .fechaHoraSalida(new Date())
                    .fechaHoraLlegada(new Date())
                    .id("12345").idAvion("54321").build(),
            new VueloDTO("Buenaventura",
                    "Cali",
                    new Date(),
                    new Date(),
                    "101234",
                    "101234"
            ),
            new VueloDTO("Medellin",
                    "Cali",
                    new Date(),
                    new Date(),
                    "201234",
                    "201234"
            )
    );
    }

}
