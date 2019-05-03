package com.tomasznajda.rxdao.dbflow

import com.raizlabs.android.dbflow.config.DatabaseDefinition
import com.tomasznajda.rxdao.query.Query

interface DbFlowQuery<ModelT> : Query<DatabaseDefinition, ModelT>