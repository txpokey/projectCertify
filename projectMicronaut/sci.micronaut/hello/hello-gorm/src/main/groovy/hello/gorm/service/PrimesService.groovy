package hello.gorm.service

import grails.gorm.services.Service
import groovy.transform.CompileStatic
import hello.gorm.domain.Primes

@CompileStatic
@Service(Primes)
abstract class PrimesService{
    abstract List<Primes> findAll()
    abstract Primes save(Primes just)
}
