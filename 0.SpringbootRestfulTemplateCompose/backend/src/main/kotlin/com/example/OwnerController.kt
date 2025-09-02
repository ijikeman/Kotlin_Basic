package com.example

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/owners")
class OwnerController(private val ownerService: OwnerService) {

    @GetMapping
    fun getAllOwners(): List<Owner> = ownerService.getAllOwners()

    @PostMapping
    fun addOwner(@RequestBody owner: Owner): Owner = ownerService.addOwner(owner)

    @PutMapping("/{id}")
    fun updateOwner(@PathVariable id: Long, @RequestBody owner: Owner): Owner = ownerService.updateOwner(id, owner)

    @DeleteMapping("/{id}")
    fun deleteOwner(@PathVariable id: Long) = ownerService.deleteOwner(id)
}
