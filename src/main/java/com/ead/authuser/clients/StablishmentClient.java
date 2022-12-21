package com.ead.authuser.clients;

import com.ead.authuser.dtos.ResponsePageDto;
import com.ead.authuser.dtos.StablishmentDto;
import com.ead.authuser.services.UtilService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Log4j2
@Component
public class StablishmentClient {

    @Autowired
    RestTemplate restTemplate;

    public Page<StablishmentDto> getAllStablishmentsByUser(UUID userId, Pageable pageable){

        List<StablishmentDto> searchResult = null;
        ResponseEntity<ResponsePageDto<StablishmentDto>> result = null;

        String url = new UtilService().createUrl(userId,pageable);

        try {
            ParameterizedTypeReference<ResponsePageDto<StablishmentDto>> responseType =
                    new ParameterizedTypeReference<ResponsePageDto<StablishmentDto>>() {};

            result = restTemplate.exchange(url, HttpMethod.GET, null, responseType);
            searchResult = result.getBody().getContent();

        }catch (Exception e){
            log.error("Error request /stablishments {}", e);
        }

        return result.getBody();
    }

    public StablishmentDto findStablishmentById(UUID stablishmentId){
        StablishmentDto stablishmentDto = null;
        ResponseEntity<StablishmentDto> result = null;

        String url = new UtilService().createUrl(stablishmentId);

        try {
            ParameterizedTypeReference<StablishmentDto> responseType =
                    new ParameterizedTypeReference<StablishmentDto>() {};

            result = restTemplate.exchange(url, HttpMethod.GET, null, responseType);
            stablishmentDto = result.getBody();

        }catch (Exception e){
            log.error("Error request /stablishments {}", e);
        }
        return stablishmentDto;
    }

}
