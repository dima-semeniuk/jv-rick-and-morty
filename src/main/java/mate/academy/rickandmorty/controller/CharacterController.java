package mate.academy.rickandmorty.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.internal.CharacterInternalDto;
import mate.academy.rickandmorty.service.CharacterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Character management", description = "Endpoints for managing characters")
@RequiredArgsConstructor
@RestController
@RequestMapping("/characters")
public class CharacterController {
    private final CharacterService characterService;

    @GetMapping("/random")
    @Operation(summary = "Get random character",
            description = "Get character by random generated ID")
    public CharacterInternalDto getRandomCharacter() {
        return characterService.getRandomCharacter();
    }

    @GetMapping
    @Operation(summary = "Get characters by name",
            description = "Get list of characters by name ignoring case")
    public List<CharacterInternalDto> getRandomCharacter(@RequestParam String name) {
        return characterService.findByName(name);
    }
}