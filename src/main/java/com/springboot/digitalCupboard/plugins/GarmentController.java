package com.springboot.digitalCupboard.plugins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.springboot.digitalCupboard.adapters.GarmentRepresentation;
import com.springboot.digitalCupboard.adapters.mappers.GarmentToRepresentationMapper;
import com.springboot.digitalCupboard.adapters.mappers.RepresentationToGarmentMapper;
import com.springboot.digitalCupboard.application.GarmentService;
import com.springboot.digitalCupboard.domain.Garment;
import com.springboot.digitalCupboard.domain.Exceptions.GarmentNotFoundException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class GarmentController {
    private final GarmentService garmentService;
    private final GarmentToRepresentationMapper toRepresentation;
    private final RepresentationToGarmentMapper toGarment;
    private final GarmentModelAssembler assembler;

    @Autowired
    public GarmentController(GarmentService garmentService, GarmentToRepresentationMapper toRepresentation, RepresentationToGarmentMapper toGarment, GarmentModelAssembler assembler) {
        this.garmentService = garmentService;
        this.toRepresentation = toRepresentation;
        this.toGarment = toGarment;
        this.assembler = assembler;
    }

    @GetMapping("/garment/{id}")
    public EntityModel<GarmentRepresentation> one(@PathVariable String id) {
        Garment garment = garmentService.findById(id).orElseThrow(() -> new GarmentNotFoundException(id));
        return assembler.toModel(toRepresentation.apply(garment));
    }

    @GetMapping("/garment")
    public CollectionModel<EntityModel<GarmentRepresentation>> all() {
        List<EntityModel<GarmentRepresentation>> garments = garmentService.findAll().stream()
                .map(toRepresentation)
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(garments,
                linkTo(methodOn(GarmentController.class).all()).withSelfRel());
    }

    @PostMapping("/garment")
    public ResponseEntity<?> newGarment(@RequestBody GarmentRepresentation newGarment) {
        String id = newGarment.getId() == null ||
        		newGarment.getId().isBlank() ||
        		newGarment.getId().equals("undefined") ?
                UUID.randomUUID().toString() :
                	newGarment.getId();
        newGarment.setId(id);
        Garment saved = garmentService.save(toGarment.apply(newGarment));
        EntityModel<GarmentRepresentation> entityModel = assembler.toModel(toRepresentation.apply(saved));
        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @PostMapping("/garment/{id}")
    public ResponseEntity<?> update(@RequestBody GarmentRepresentation newGarment, @PathVariable String id) {

        Garment oldGarment = garmentService.findById(id).orElseThrow(() -> new GarmentNotFoundException(id));
        Garment updatedGarment = toGarment.update(oldGarment, newGarment);

        Garment saved = garmentService.save(updatedGarment);

        EntityModel<GarmentRepresentation> entityModel = assembler.toModel(toRepresentation.apply(saved));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @DeleteMapping("/garment/{id}")
    public ResponseEntity<?> delete(@PathVariable String id)  {

        garmentService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
