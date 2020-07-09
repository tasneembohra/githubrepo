package com.tasneembohra.github.remote

interface IBaseResponse<DomainModel> {
    fun build(): DomainModel
}