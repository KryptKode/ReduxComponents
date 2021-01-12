package com.kryptkode.remote.mapper

interface DataEntityMapper<in R, out D> {
    fun mapToEntity(remote: R): D
}