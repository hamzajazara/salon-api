package com.hamzajazara.salon.booking.api.controller.lookup;

import com.hamzajazara.salon.booking.api.entity.lookup.LanguageEntity;
import com.hamzajazara.salon.booking.api.model.response.lookup.LanguageResponse;
import com.hamzajazara.salon.booking.api.service.lookup.LanguageService;
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
@RestController("LanguageLookUpController")
@RequestMapping("/api/lookup/language")
@Api(tags = "Lookup")
public class LanguageLookupController {

    @Autowired
    private LanguageService languageService;

    @GetMapping
    @ApiOperation(value = "Allow the user to view all languages")
    public PageImpl<LanguageResponse> viewLanguages(Pageable pageable) {
        Page<LanguageEntity> languages = languageService.getLanguage(pageable);
        List<LanguageResponse> languageResponses = new ArrayList<>();
        languages.forEach(language -> languageResponses.add(new LanguageResponse(language)));
        return new PageImpl<>(languageResponses, pageable, languages.getTotalElements());
    }

    @GetMapping("/{languageId}")
    @ApiOperation(value = "Allow the user to view a specific language")
    public ResponseEntity<LanguageResponse> viewLanguage(@PathVariable("languageId") long languageId) {
        return new ResponseEntity<>(new LanguageResponse(languageService.getLanguage(languageId)), HttpStatus.OK);
    }
}
