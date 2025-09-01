package com.example

import org.springframework.data.jpa.repository.JpaRepository

interface OwnerRepository : JpaRepository<Owner, Long>
