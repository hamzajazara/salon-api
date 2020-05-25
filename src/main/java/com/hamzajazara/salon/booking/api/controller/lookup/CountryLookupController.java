package com.hamzajazara.salon.booking.api.controller.lookup;

import com.hamzajazara.salon.booking.api.entity.lookup.CountryEntity;
import com.hamzajazara.salon.booking.api.model.response.lookup.CountryResponse;
import com.hamzajazara.salon.booking.api.service.lookup.CountryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hamza Aljazara
 */
@RestController("CountryLookUpController")
@RequestMapping("/api/lookup/country")
@Api(tags = "Lookup")
public class CountryLookupController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    @ApiOperation(value = "Allow the user to view all cities")
    public PageImpl<CountryResponse> viewCountries(Pageable pageable) {
        Page<CountryEntity> countries = countryService.getCountry(pageable);
        List<CountryResponse> countryResponses = new ArrayList<>();
        countries.forEach(country -> countryResponses.add(new CountryResponse(country)));
        return new PageImpl<>(countryResponses, pageable, countries.getTotalElements());
    }

    @GetMapping("/{countryId}")
    @ApiOperation(value = "Allow the user to view a specific country")
    public ResponseEntity<CountryResponse> viewCountry(@PathVariable("countryId") long countryId) {
        return new ResponseEntity<>(new CountryResponse(countryService.getCountry(countryId)), HttpStatus.OK);
    }
}
