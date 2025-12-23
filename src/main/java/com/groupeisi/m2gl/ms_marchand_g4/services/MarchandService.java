package com.groupeisi.m2gl.ms_marchand_g4.services;

import com.groupeisi.m2gl.ms_marchand_g4.clients.TrxEngineClient;
import com.groupeisi.m2gl.ms_marchand_g4.clients.dto.UserResponse;
import com.groupeisi.m2gl.ms_marchand_g4.entities.Marchand;
import com.groupeisi.m2gl.ms_marchand_g4.graphql.MarchandMutationResolver;
import com.groupeisi.m2gl.ms_marchand_g4.repository.MarchandRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarchandService {
    private final MarchandRepository repo;
    private final PasswordEncoder passwordEncoder;
    private final TrxEngineClient trxEngineClient;

    public MarchandService(MarchandRepository repo, PasswordEncoder passwordEncoder, TrxEngineClient trxEngineClient) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
        this.trxEngineClient = trxEngineClient;
    }

    public Marchand createMarchand(MarchandMutationResolver.MarchandInput input){
        try{
            UserResponse user =
                    trxEngineClient.getUserByPhone(input.telephone());

            if (user == null || user.getData() == null) {
                throw new RuntimeException("Utilisateur introuvable");
            }

            Marchand marchand = new Marchand();
            marchand.setNomBoutique(input.nomBoutique());
            marchand.setLogoBoutique(input.logoBoutique());
            marchand.setPassword(passwordEncoder.encode(input.password()));
            marchand.setUser_id(user.getData().getId());

            return repo.save(marchand);
        }catch (Exception e){
            System.out.println("Erreur "+e.getMessage());
        }
       return null;
    }
    public List<Marchand> getAllMarchands() {
        return repo.findAll();
    }

    public Marchand getMarchandById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
