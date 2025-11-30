package com.groupeisi.m2gl.ms_marchand_g4.graphql;

import com.groupeisi.m2gl.ms_marchand_g4.entities.Marchand;
import com.groupeisi.m2gl.ms_marchand_g4.repository.MarchandRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserQueryResolver {

    private final MarchandRepository repo;

    public UserQueryResolver(MarchandRepository repo) {
        this.repo = repo;
    }

    @QueryMapping
    public List<Marchand> marchands() {
        return repo.findAll();
    }

    @QueryMapping
    public Marchand marchand(@Argument Long id) {
        return repo.findById(id).orElse(null);
    }
}
