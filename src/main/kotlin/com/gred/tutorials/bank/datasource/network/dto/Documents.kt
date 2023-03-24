package com.gred.tutorials.bank.datasource.network.dto

import com.gred.tutorials.bank.model.Bank

data class Documents(
    val documents: Collection<Bank>
)