package com.example

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OwnerService(private val ownerRepository: OwnerRepository) {

    fun getAllOwners(): List<Owner> = ownerRepository.findAll()

    @Transactional
    fun addOwner(owner: Owner): Owner = ownerRepository.save(owner)

    @Transactional
    fun updateOwner(id: Long, ownerDetails: Owner): Owner {
        val owner = ownerRepository.findById(id).orElseThrow { RuntimeException("Owner not found") }
        owner.name = ownerDetails.name
        owner.address = ownerDetails.address
        return ownerRepository.save(owner)
    }

    @Transactional
    fun deleteOwner(id: Long) {
        ownerRepository.deleteById(id)
    }
}
