package kim.young.fakestoreapp.shared.domain.type

import kim.young.fakestoreapp.shared.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

abstract class UseCaseOut<OUT> {
    operator fun invoke(): Flow<Resource<OUT>> = flow {
        emit(
            try {
                Resource.Success(block())
            } catch (ex: Exception) {
                Resource.Error(exception = ex)
            }
        )
    }

    protected abstract val block: suspend () -> OUT
}

abstract class UseCaseOutFlow<OUT> {
    operator fun invoke(): Flow<Resource<OUT>> = try {
        build().map { Resource.Success(data = it) }
    } catch (ex: Exception) {
        flowOf(Resource.Error(exception = ex))
    }

    protected abstract fun build(): Flow<OUT>
}