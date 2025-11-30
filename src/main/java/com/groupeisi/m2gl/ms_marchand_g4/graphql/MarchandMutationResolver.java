package com.groupeisi.m2gl.ms_marchand_g4.graphql;

import com.groupeisi.m2gl.ms_marchand_g4.entities.Marchand;
import com.groupeisi.m2gl.ms_marchand_g4.services.MarchandService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MarchandMutationResolver {

    private final MarchandService marchandService;

    public MarchandMutationResolver(MarchandService marchandService) {

        this.marchandService = marchandService;
    }

    @MutationMapping
    public Marchand createMarchand(@Argument MarchandInput input) {
       return  marchandService.createMarchand(
               input.nomBoutique(),
               input.logoBoutique(),
               input.password(),
               input.user_id());

    }
    public record MarchandInput(String nomBoutique, String logoBoutique, String password,Integer user_id) {}
}