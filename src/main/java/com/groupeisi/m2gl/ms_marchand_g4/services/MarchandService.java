package com.groupeisi.m2gl.ms_marchand_g4.services;

import com.groupeisi.m2gl.ms_marchand_g4.entities.Marchand;
import com.groupeisi.m2gl.ms_marchand_g4.repository.MarchandRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarchandService {
    private final MarchandRepository repo;
    private final PasswordEncoder passwordEncoder;

    public MarchandService(MarchandRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    public Marchand createMarchand(String nomBoutique, String logoBoutique, String password, Integer user_id) {
        Marchand m = new Marchand();
        m.setNomBoutique(nomBoutique);
        m.setLogoBoutique(logoBoutique);
        m.setPassword(passwordEncoder.encode(password));
        m.setUser_id(user_id);
        return repo.save(m);
    }
    public List<Marchand> getAllMarchands() {
        return repo.findAll();
    }

    public Marchand getMarchandById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
