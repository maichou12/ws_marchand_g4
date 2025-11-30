package com.groupeisi.m2gl.ms_marchand_g4.graphql;

import com.groupeisi.m2gl.ms_marchand_g4.entities.Marchand;
import com.groupeisi.m2gl.ms_marchand_g4.repository.MarchandRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MarchandMutationResolver {

    private final MarchandRepository repo;

    public MarchandMutationResolver(MarchandRepository repo) {
        this.repo = repo;
    }

    @MutationMapping
    public Marchand createMarchand(@Argument MarchandInput input) {
        Marchand m = new Marchand();
        m.setNomBoutique(input.nomBoutique());
        m.setLogoBoutique(input.logoBoutique());
        m.setPassword(input.password());
        m.setUser_id(input.user_id());
        return repo.save(m);
    }
    public record MarchandInput(String nomBoutique, String logoBoutique, String password,Integer user_id) {}
}