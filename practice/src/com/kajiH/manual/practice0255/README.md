## ヒットアンドブロー

## 説明
正解の4桁の数字を予想し回答する  
数字と場所が同じ数をヒット数、数字が同じ数をブロー数として返す  
このヒットとブローの数の情報から正解の数字を当てるゲーム  

正解の数字は3桁の場合もある、また数字でなく文字・模様を使用する場合もある  
プレイヤー数は1，2人である

## 設定
今回のゲームでは正解を0~9の数字のみとし  
複数回ごとにヒントを出力するようにする  
また、回答数、ヒントの間隔はプレイヤー1人に対する回数である  
以下、設定値とする  
|要素|取りうる値|
|---|---| 
|プレイヤー|1人以上|
|数字|4桁 ~ 5桁|  
|選択肢|0,1,2,3,4,5,6,7,8,9|
|回答数|1回以上|
|ヒントの間隔|1回以上|

## フロー
- ### 正解の数字を設定  
  正解の数字は重複を含まない

- ### 数字の選択  
  正解の数字と同じ桁数を半角の数字で入力  

- ### 正解判定
  選択した数字が全てヒットした場合、結果を表示  
  選択した数字が全てヒットしてない場合、  
  ヒットとブローの数を表示し、次のプレイヤーが数字の選択を行う  

- ### 正解の数字を一つ出力  
  全てのプレイヤーの回答が一定の回数行われるたびに  
  正解の数字を1つ出力する  
  正解の数字は前から順番に出力する  

- ### 結果を表示  
  回答数以内に正解できた場合、
  正解になるまでの回答数と正解したプレイヤー名を出力
  回答数以内に正解できなかった場合、  
  正解の数字を表示
