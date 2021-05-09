package spring.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.hibernate.dto.Subject;
import spring.hibernate.repository.SubjectRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public void deleteSubject(Subject subject) {
        subjectRepository.delete(subject);
    }

    @Override
    public Subject getSubjectById(Long id) {
        Optional<Subject> optional = subjectRepository.findById(id);
        Subject subject =null;
        if(optional.isPresent()){
            subject = optional.get();
        }else{
            throw new RuntimeException(" Subject not found for id :: " + id);
        }
        return subject;
    }
}
