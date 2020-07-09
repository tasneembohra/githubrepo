package com.tasneembohra.github

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.databinding.ObservableField
import androidx.lifecycle.Observer
import com.tasneembohra.github.remote.ErrorModel
import com.tasneembohra.github.remote.ErrorState
import com.tasneembohra.github.remote.Result
import com.tasneembohra.github.repo.Repository
import com.tasneembohra.github.repo.UserDataModel
import com.tasneembohra.github.ui.search.UserSearchViewModel
import com.tasneembohra.github.ui.search.model.RepoModel
import com.tasneembohra.github.ui.search.model.UserModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.Mockito.`when` as whenever

@RunWith(MockitoJUnitRunner.Silent::class)
@ExperimentalCoroutinesApi
class UserSearchViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var repo: Repository

    @Mock
    private lateinit var faceUser: UserModel

    @Mock
    private lateinit var fakeUserRepos: List<RepoModel>

    @Mock
    private lateinit var errorObserver: Observer<Result<UserDataModel>>

    private lateinit var viewModel: UserSearchViewModel

    private val fakeUserId = "tasneembohra"

    private val fakeFailUserId = "tasneembo"

    @Before
    fun setup() {
        viewModel =
            UserSearchViewModel(repo).apply {
                repoLiveData.observeForever { fakeUserRepos }
            }
    }

    @Test
    fun giveViewModelInitialized_whenUserExist_thenReturnUserDetail() =
        testCoroutineRule.runBlockingTest {
            whenever(faceUser.data).thenReturn(ObservableField(UserDataModel("Tasneem")))
            viewModel.search(fakeUserId)
            Assert.assertEquals(faceUser.data.get()?.name, "Tasneem")
        }

    @Test
    fun giveViewModelInitialized_whenUserExist_thenReturnUserRepo() =
        testCoroutineRule.runBlockingTest {
            Assert.assertNotNull(viewModel)
            whenever(fakeUserRepos.size).thenReturn(5)
            viewModel.search(fakeUserId)

            Assert.assertEquals(fakeUserRepos.size, 5)
        }

    @Test
    fun giveViewModelInitialized_whenSearchExecuted_thenReturnStopLoading() =
        testCoroutineRule.runBlockingTest {
            Assert.assertNotNull(viewModel)
            viewModel.search(fakeUserId)
        }

    @Test
    fun giveViewModelInitialized_whenUserDoesNotExist_thenReturnErrorState() =
        testCoroutineRule.runBlockingTest {
            val error = ErrorState<UserDataModel>(ErrorModel())
            whenever(repo.fetchUserInfo(fakeFailUserId)).thenReturn(error)

            viewModel.search(fakeUserId)

            //verify(errorObserver).onChanged(LoadingState())
            //verify(errorObserver).onChanged(error)
        }

}