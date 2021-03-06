/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.toanit.github.ui.user;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.VisibleForTesting;

import com.toanit.github.repository.RepoRepository;
import com.toanit.github.repository.UserRepository;
import com.toanit.github.util.AbsentLiveData;
import com.toanit.github.util.Objects;
import com.toanit.github.vo.Repo;
import com.toanit.github.vo.Resource;
import com.toanit.github.vo.User;

import java.util.List;

import javax.inject.Inject;

public class UserViewModel extends ViewModel {
    @VisibleForTesting
    final MutableLiveData<String> login = new MutableLiveData<>();
    private final LiveData<Resource<List<Repo>>> repositories;
    private final LiveData<Resource<User>> user;
    @SuppressWarnings("unchecked")
    @Inject
    public UserViewModel(UserRepository userRepository, RepoRepository repoRepository) {
        user = Transformations.switchMap(login, login -> {
            if (login == null) {
                return AbsentLiveData.create();
            } else {
                return userRepository.loadUser(login);
            }
        });
        repositories = Transformations.switchMap(login, login -> {
            if (login == null) {
                return AbsentLiveData.create();
            } else {
                return repoRepository.loadRepos(login);
            }
        });
    }

    void setLogin(String login) {
        if (Objects.equals(this.login.getValue(), login)) {
            return;
        }
        this.login.setValue(login);
    }

    LiveData<Resource<User>> getUser() {
        return user;
    }

    LiveData<Resource<List<Repo>>> getRepositories() {
        return repositories;
    }

    void retry() {
        if (this.login.getValue() != null) {
            this.login.setValue(this.login.getValue());
        }
    }
}
