package webUi.controllers;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import webUi.entity.Specialty;
import webUi.entity.Vet;
import webUi.repository.SpecialtyRepository;
import webUi.repository.VetRepository;
import webUi.vet.*;

import java.util.*;

@Controller
public class VetController {
    private final VetRepository vetRepository;
    private final SpecialtyRepository specialtyRepository;
    private static final String VIEWS_VET_CREATE = "vets/createVet";

    public VetController(VetRepository clinicService, SpecialtyRepository specialtyRepository) {
        this.vetRepository = clinicService;
        this.specialtyRepository = specialtyRepository;
    }

    @ModelAttribute("specialtiesAll")
    public Collection<Specialty> findAllSpecialty() {
        return this.specialtyRepository.findSpecialty();
    }

    @GetMapping("/vets/new")
    public String initCreationForm(Map<String, Object> model) {
        Vet vet = new Vet();
        model.put("vet", vet);
        return VIEWS_VET_CREATE;
    }

    @PostMapping("/vets/new")
    public String processCreationForm(@Valid Vet vet, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_VET_CREATE;
        }
        Specialty specialty = new Specialty();
        specialty.setName(vet.getAddSpecialty());
        vet.addSpecialty(specialty);
        this.vetRepository.save(vet);
        return "redirect:/vets.html";
    }

    @GetMapping("/vets.html")
    public String showVetList(@RequestParam(defaultValue = "1") int page, Model model) {
        // Here we are returning an object of type 'Vets' rather than a collection of Vet
        // objects so it is simpler for Object-Xml mapping
        Vets vets = new Vets();
        Page<Vet> paginated = findPaginated(page);
        vets.getVetList().addAll(paginated.toList());
        System.out.println(paginated.getContent());
        List<Vet> listVets = paginated.getContent();
        System.out.println(paginated.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", paginated.getTotalPages());
        model.addAttribute("totalItems", paginated.getTotalElements());
        model.addAttribute("listVets", listVets);
        return "/vets/vetList";
    }

    private Page<Vet> findPaginated(int page) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return vetRepository.findAll(pageable);
    }

    @GetMapping({ "/vets" })
    public @ResponseBody Vets showResourcesVetList() {
        // Here we are returning an object of type 'Vets' rather than a collection of Vet
        // objects so it is simpler for JSon/Object mapping
        Vets vets = new Vets();
        vets.getVetList().addAll(this.vetRepository.findAll());
        return vets;
    }
}
