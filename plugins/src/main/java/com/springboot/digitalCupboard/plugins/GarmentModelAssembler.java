package com.springboot.digitalCupboard.plugins;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.springboot.digitalCupboard.adapters.GarmentRepresentation;

@Component
public class GarmentModelAssembler implements RepresentationModelAssembler<GarmentRepresentation, EntityModel<GarmentRepresentation>>{

    public EntityModel<GarmentRepresentation> toModel(GarmentRepresentation garmentRepresentation) {
        return EntityModel.of(garmentRepresentation,
                linkTo(methodOn(GarmentController.class).one(garmentRepresentation.getId())).withSelfRel(),
                linkTo(methodOn(GarmentController.class).all()).withRel("kategorien"),
                linkTo(methodOn(GarmentController.class).newGarment(garmentRepresentation)).withRel("post"),
                linkTo(methodOn(GarmentController.class).update(garmentRepresentation, garmentRepresentation.getId())).withRel("update"),
                linkTo(methodOn(GarmentController.class).delete(garmentRepresentation.getId())).withRel("delete")
        );
    }
}
