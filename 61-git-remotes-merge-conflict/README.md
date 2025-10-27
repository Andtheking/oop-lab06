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
 ~/oop-lab06/61-git-remotes-merge-conflict  exercises  git clone https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test                                                  ✔  root@lab22-07-07  11:02:17 
Cloning into 'OOP-git-merge-conflict-test'...
remote: Enumerating objects: 12, done.
remote: Counting objects: 100% (4/4), done.
remote: Compressing objects: 100% (3/3), done.
remote: Total 12 (delta 1), reused 1 (delta 1), pack-reused 8 (from 1)
Receiving objects: 100% (12/12), done.
Resolving deltas: 100% (2/2), done.
 
~/oop-lab06/61-git-remotes-merge-conflict  exercises !1 ?1  cd OOP-git-merge-conflict-test                                                                                    ✔  root@lab22-07-07  11:06:42 

~/oop-lab06/61/OOP-git-merge-conflict-test  master  git status                                                                                                                ✔  root@lab22-07-07  11:06:50 
On branch master
Your branch is up to date with 'origin/master'.

nothing to commit, working tree clean

```
2. Ci si assicuri di avere localmente entrambi i branch remoti
```bash
 ~/oop-lab06/61/OOP-git-merge-conflict-test  master  git branch -a  
* master
  remotes/origin/HEAD -> origin/master
  remotes/origin/feature
  remotes/origin/master
(END)
 ~/oop-lab06/61/OOP-git-merge-conflict-test  master  git checkout feature                                                                                                      ✔  root@lab22-07-07  11:10:29 

branch 'feature' set up to track 'origin/feature'.
Switched to a new branch 'feature'
 ~/oop-lab06/61/OOP-git-merge-conflict-test  feature  git log --oneline --graph --all                                                                                          ✔  root@lab22-07-07  11:10:47 

 ~/oop-lab06/61/OOP-git-merge-conflict-test  feature  git checkout master                                                                                                      ✔  root@lab22-07-07  11:10:50 

Switched to branch 'master'
Your branch is up to date with 'origin/master'.

~/oop-lab06/61/OOP-git-merge-conflict-test  master  git branch -a    
   feature
* master
  remotes/origin/HEAD -> origin/master
  remotes/origin/feature
  remotes/origin/master
```
3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master`
   e da qui si esegua il merge di `feature`
```bash
  ~/oop-lab06/61/OOP-git-merge-conflict-test  master  git merge feature                                                                                                         ✔  root@lab22-07-07  11:12:07 
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
 ~/oop-lab06/61/OOP-git-merge-conflict-test  master  git merge feature                                                                                                         ✔  root@lab22-07-07  11:12:07 

Auto-merging HelloWorld.java
CONFLICT (content): Merge conflict in HelloWorld.java
Automatic merge failed; fix conflicts and then commit the result.
 ~/oop-lab06/61/OOP-git-merge-conflict-test  master merge ~1  git status                                                                                                     1 ✘  root@lab22-07-07  11:12:16 

On branch master
Your branch is up to date with 'origin/master'.

All conflicts fixed but you are still merging.
  (use "git commit" to conclude merge)

Changes to be committed:
        modified:   HelloWorld.java

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   HelloWorld.java

 ~/oop-lab06/61/OOP-git-merge-conflict-test  master merge +1 !1  git add HelloWorld.java                                                                                       ✔  root@lab22-07-07  11:15:52 

 ~/oop-lab06/61/OOP-git-merge-conflict-test  master merge +1  git commit -m "merge(feature): print author"                                                                     ✔  root@lab22-07-07  11:15:58 
[master 5488e1e] merge(feature): print author
```
6. Si crei un nuovo repository nel proprio github personale

7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote

8. Si faccia push del branch `master` sul proprio repository

9. Si setti il branch remoto `master` del nuovo repository come *upstream* per il proprio branch `master` locale

