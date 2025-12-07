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

    public Marchand createMarchand(MarchandMutationResolver.MarchandInput input) {
        // 1. Vérifier si l’utilisateur existe dans TRX-ENGINE
        UserResponse user = trxEngineClient.getUserByPhone(input.telephone());
        //TODO: gérer le cas où l'utilisateur n'existe pas
        //TODO: Verifier la serialisation cote TRX-ENGINE
        if (user == null || user.getId() == null) {
            throw new RuntimeException("Aucun utilisateur trouvé avec ce numéro.");
        }
        //TODO: Creer et Récupérer le compte_id depuis TRX-ENGINE
        Integer compteId = 1; // Valeur fictive, à remplacer par la vraie récupération
        // 2. Hasher le password
        String hashedPassword = passwordEncoder.encode(input.password());

        // 3. Sauvegarder le marchand
        Marchand marchand = new Marchand();
        marchand.setNomBoutique(input.nomBoutique());
        marchand.setLogoBoutique(input.logoBoutique());
        marchand.setPassword(hashedPassword);
        marchand.setUser_id(user.getId());// Vient de TRX-ENGINE
        marchand.setCompte_id(compteId);

        return repo.save(marchand);
    }
    public List<Marchand> getAllMarchands() {
        return repo.findAll();
    }

    public Marchand getMarchandById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
