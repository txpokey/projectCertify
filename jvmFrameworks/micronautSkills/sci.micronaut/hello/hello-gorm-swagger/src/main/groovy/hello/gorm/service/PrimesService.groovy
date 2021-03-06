package hello.gorm.service

import grails.gorm.services.Service
import groovy.transform.CompileStatic
import hello.gorm.domain.Primes

import javax.annotation.Nonnull

@CompileStatic
@Service(Primes)
abstract class PrimesService{
    abstract List<Primes> findAll()
    abstract List<Primes> findAllByTruth(@Nonnull Boolean state)
    abstract Primes save(Primes just)
}
