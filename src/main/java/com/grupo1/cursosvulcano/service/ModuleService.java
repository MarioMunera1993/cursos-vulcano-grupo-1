package com.grupo1.cursosvulcano.service;
import com.grupo1.cursosvulcano.model.entity.Module;
import com.grupo1.cursosvulcano.repository.ModuleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleService {
        @Autowired
        private ModuleRepository moduleRepository;
    
        public List<Module> getAllModules() {
            return moduleRepository.findAll();
        } 

        public Module createModule(Module module) {
            return moduleRepository.save(module);
        }

        public Module updateModule(Long id, Module moduleDetails) {
            Module module = moduleRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Module not found with id " + id));
    
            module.setContenido(moduleDetails.getContenido());
            module.setVideoUrl(moduleDetails.getVideoUrl());
            module.setDurationInMinutes(moduleDetails.getDurationInMinutes());
            module.setStatus(moduleDetails.getStatus());
    
            return moduleRepository.save(module);
        }


        public void deleteModule(Long id) {
            Module module = moduleRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Module not found with id " + id));
            moduleRepository.delete(module);
        }

}
