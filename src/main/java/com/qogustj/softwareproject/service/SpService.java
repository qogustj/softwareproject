package com.qogustj.softwareproject.service;

import com.qogustj.softwareproject.domain.Member;
import com.qogustj.softwareproject.repository.MemorySpRepository;
import com.qogustj.softwareproject.repository.SpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpService {
    private final SpRepository spRepository;

    @Autowired
    public SpService(SpRepository spRepository) {
        this.spRepository = spRepository;
    }
    public Member create(Member member){
        return spRepository.save(member);
    }
    public Optional<Member>/*null일수있는객체받을때*/ read(Long id){
        return spRepository.findById(id);
    }
    public Optional<Member> update(Long id, int master){
        Member member = read(id).get();
        member.setMaster(master);
        return Optional.ofNullable(spRepository.save(member));
    }
    public void delete(Long id){
        spRepository.deleteById(id);
    }
}
