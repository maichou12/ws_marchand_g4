package com.groupeisi.m2gl.ms_marchand_g4.graphql;

import com.groupeisi.m2gl.ms_marchand_g4.entities.Marchand;
import com.groupeisi.m2gl.ms_marchand_g4.services.MarchandService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserQueryResolver {
    private final MarchandService marchandService;

    public UserQueryResolver(MarchandService marchandService) {
        this.marchandService = marchandService;
    }

    @QueryMapping
    public List<Marchand> marchands() {
       return marchandService.getAllMarchands();
    }

    @QueryMapping
    public Marchand marchand(@Argument Long id) {
       return marchandService.getMarchandById(id);
    }
}
