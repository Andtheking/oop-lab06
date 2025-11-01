# Esercizio di risoluzione di un merge conflict

**Il tempo massimo in laboratorio per questo esercizio è di _20 minuti_.
Se superato, sospendere l'esercizio e riprenderlo per ultimo!**

Si visiti https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.
Questo repository contiene due branch: `master` e `feature`

Per ognuna delle seguenti istruzioni, si annoti l'output ottenuto.
Prima di eseguire ogni operazione sul worktree o sul repository,
si verifichi lo stato del repository con `git status`.

1. Si cloni localmente il repository
```bash
$ git clone https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test

Cloning into 'OOP-git-merge-conflict-test'...
remote: Enumerating objects: 12, done.
remote: Counting objects: 100% (4/4), done.
remote: Compressing objects: 100% (3/3), done.
remote: Total 12 (delta 1), reused 1 (delta 1), pack-reused 8 (from 1)
Receiving objects: 100% (12/12), done.
Resolving deltas: 100% (2/2), done.
 
$ cd OOP-git-merge-conflict-test

$ git status

On branch master
Your branch is up to date with 'origin/master'.

nothing to commit, working tree clean
```
2. Ci si assicuri di avere localmente entrambi i branch remoti
```bash
$ git branch -a  

* master
  remotes/origin/HEAD -> origin/master
  remotes/origin/feature
  remotes/origin/master
(END)

$ git checkout feature

branch 'feature' set up to track 'origin/feature'.
Switched to a new branch 'feature'

$ git log --oneline --graph --all

* bed943f (HEAD -> feature, origin/feature) Print author information
| * 8e0f29c (origin/master, origin/HEAD, master) Change HelloWorld to print the number of available processors
|/
* d956df6 Create .gitignore
* 700ee0b Create HelloWorld
(END)

$ git checkout master

Switched to branch 'master'
Your branch is up to date with 'origin/master'.

$ git branch -a 

  feature
* master
  remotes/origin/HEAD -> origin/master
  remotes/origin/feature
  remotes/origin/master
```
3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master`
   e da qui si esegua il merge di `feature`
```bash
$ git merge feature

Auto-merging HelloWorld.java
CONFLICT (content): Merge conflict in HelloWorld.java
Automatic merge failed; fix conflicts and then commit the result.
```

4. Si noti che viene generato un **merge conflict**!
5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili
     (funzionalità presente su `master`)
     che il nome dell'autore del file
     (funzionalità presente su `feature`)
```bash
(Conflitti risolti su vs code)

$ git status 

On branch master
Your branch is up to date with 'origin/master'.

You have unmerged paths.
  (fix conflicts and run "git commit")
  (use "git merge --abort" to abort the merge)

Unmerged paths:
  (use "git add <file>..." to mark resolution)
        both modified:   HelloWorld.java

no changes added to commit (use "git add" and/or "git commit -a")

$ git add HelloWorld.java

$ git status

On branch master
Your branch is up to date with 'origin/master'.

All conflicts fixed but you are still merging.
  (use "git commit" to conclude merge)

Changes to be committed:
        modified:   HelloWorld.java
        
$ git commit -m "Merge branch 'feature'"

[master 7ac2cf8] Merge branch 'feature'

$ git status

On branch master
Your branch is ahead of 'origin/master' by 2 commits.
  (use "git push" to publish your local commits)

nothing to commit, working tree clean
```
6. Si crei un nuovo repository nel proprio github personale

7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote
```bash
$ git remote add mia-repo git@github.com:Andtheking/OOP-git-merge-conflict-test.git

$ git remote -v

mia-repo  https://github.com/Andtheking/OOP-git-merge-conflict-test (fetch)
mia-repo  https://github.com/Andtheking/OOP-git-merge-conflict-test (push)
origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test (fetch)
origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test (push)

```
8. Si faccia push del branch `master` sul proprio repository
```bash
$ git push mia-repo master

Enumerating objects: 15, done.
Counting objects: 100% (15/15), done.
Delta compression using up to 2 threads
Compressing objects: 100% (11/11), done.
Writing objects: 100% (15/15), 1.57 KiB | 1.57 MiB/s, done.
Total 15 (delta 4), reused 10 (delta 2), pack-reused 0 (from 0)
remote: Resolving deltas: 100% (4/4), done.
To https://github.com/Andtheking/OOP-git-merge-conflict-test
 * [new branch]      master -> master
```
9. Si setti il branch remoto `master` del nuovo repository come *upstream* per il proprio branch `master` locale
```bash
$ git branch --set-upstream-to=mia-repo/master

branch 'master' set up to track 'mia-repo/master'.

$ git status

On branch master
Your branch is up to date with 'mia-repo/master'.

nothing to commit, working tree clean

```