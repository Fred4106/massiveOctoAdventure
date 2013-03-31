git add --all
read -p "Commit Message: " yn
git commit --message "$yn"
git push
