var express = require('express');
var bodyparser = require('body-parser');
var fs = require('fs');
var mysql = require('mysql');
var app = express();


app.use(bodyparser.json());

const conn = mysql.createConnection({
    host : '127.0.0.1',
    user : 'root',
    password : '',
    database : 'pendaftaran_turnamen'
});

conn.connect(function(err){
    if (err) throw err;
    console.log("MySQL connected.....");
});

app.get('/admin', function(req,res){
    console.log('Menerima GET request /admin');
    let sql = "SELECT * FROM admin";
    let query = conn.query(sql,function(err,result){
        if (err) throw err;
        res.send(JSON.stringify({
            "status" : 200,
            "error" : null,
            "response" : result
        }));
    });
});

app.get('/GameIndividu', function(req,res){
    console.log('Menerima GET request /Game-Individu');
    let sql = "SELECT * FROM game_individu";
    let query = conn.query(sql,function(err,result){
        if (err) throw err;
        res.send(JSON.stringify({
            "status" : 200,
            "error" : null,
            "response" : result
        }));
    });
});

app.get('/GameKelompok', function(req,res){
    console.log('Menerima GET request /Game-Kelompok');
    let sql = "SELECT * FROM game_kelompok";
    let query = conn.query(sql,function(err,result){
        if (err) throw err;
        res.send(JSON.stringify({
            "status" : 200,
            "error" : null,
            "response" : result
        }));
    });
});



app.get('/PesertaGameIndividuDiterima', function(req,res){
    console.log('Menerima GET request /PesertaGameIndividu-Diterima');
    let sql = "SELECT * FROM peserta_individu pi inner join game_individu gi on gi.idgame = pi.idpeserta WHERE status = 1";
    let query = conn.query(sql,function(err,result){
        if (err) throw err;
        res.send(JSON.stringify({
            "status" : 200,
            "error" : null,
            "response" : result
        }));
    });
});
app.get('/PesertaGameIndividuDitolak', function(req,res){
    console.log('Menerima GET request /PesertaGameIndividuDitolak');
    let sql = "SELECT * FROM peserta_individu pi inner join game_individu gi on gi.idgame = pi.idpeserta WHERE status = 2";
    let query = conn.query(sql,function(err,result){
        if (err) throw err;
        res.send(JSON.stringify({
            "status" : 200,
            "error" : null,
            "response" : result
        }));
    });
});
app.get('/PesertaGameIndividuPending', function(req,res){
    console.log('Menerima GET request /PesertaGameIndividu-Diterima');
    let sql = "SELECT * FROM peserta_individu pi inner join game_individu gi on gi.idgame = pi.idpeserta WHERE status = 0";
    let query = conn.query(sql,function(err,result){
        if (err) throw err;
        res.send(JSON.stringify({
            "status" : 200,
            "error" : null,
            "response" : result
        }));
    });
});

app.get('/PesertaGameIndividuWin', function(req,res){
    console.log('Menerima GET request /PesertaGameIndividu-Win');
    let data = {win: req.body.win};
    let sql = "SELECT * FROM peserta_individu pi inner join game_individu gi on gi.idgame = pi.idpeserta WHERE status = 1 AND win = '" + data.win + "';";
    let query = conn.query(sql,function(err,result){
        if (err) throw err;
        res.send(JSON.stringify({
            "status" : 200,
            "error" : null,
            "response" : result
        }));
    });
});

app.get('/teamTerima', function(req,res){
    console.log('Menerima GET request /Team');
    let sql = "SELECT * FROM team t inner join peserta_kelompok pk on t.idteam = pk.team_idteam inner join game_kelompok gk on t.game_kelompok_idgame=gk.idgame where status =1 group by nama_team  ;";
    let query = conn.query(sql,function(err,result){
        if (err) throw err;
        res.send(JSON.stringify({
            "status" : 200,
            "error" : null,
            "response" : result
        }));
    });
});

app.get('/teamPending', function(req,res){
    console.log('Menerima GET request /Team');
    let sql = "SELECT * FROM team t inner join game_kelompok g on t.game_kelompok_idgame=g.idgame where status = 0; ";
    let query = conn.query(sql,function(err,result){
        if (err) throw err;
        res.send(JSON.stringify({
            "status" : 200,
            "error" : null,
            "response" : result
        }));
    });
});


app.get('/TeamDiterima', function(req,res){
    console.log('Menerima GET request /Team-Diterima');
    let sql = "SELECT * FROM team t inner join peserta_kelompok pk on t.idteam = pk.team_idteam inner join game_kelompok gk on t.game_kelompok_idgame = gk.idgame WHERE status = 1 group by nama_Team; ";
    let query = conn.query(sql,function(err,result){
        if (err) throw err;
        res.send(JSON.stringify({
            "status" : 200,
            "error" : null,
            "response" : result
        }));
    });
});

app.get('/TeamDitolak', function(req,res){
    console.log('Menerima GET request /TeamDitolak');
    let sql = "SELECT * FROM team t inner join game_kelompok g on t.game_kelompok_idgame=g.idgame where status = 2;";
    let query = conn.query(sql,function(err,result){
        if (err) throw err;
        res.send(JSON.stringify({
            "status" : 200,
            "error" : null,
            "response" : result
        }));
    });
});

app.get('/leaderboardTeam', function(req,res){
    console.log('Menerima GET request /leaderboardTeam');
    let sql = "SELECT * FROM game_kelompok gk INNER JOIN team t ON gk.idgame = t.game_kelompok_idgame WHERE t.win = (SELECT MAX(win) FROM team);";
    let query = conn.query(sql,function(err,result){
        if (err) throw err;
        res.send(JSON.stringify({
            "status" : 200,
            "error" : null,
            "response" : result
        }));
    });
});





app.get('/leaderboardIndiv', function(req,res){
    console.log('Menerima GET request /leaderboardIndiv');
    let sql = "SELECT * FROM game_individu gi INNER JOIN peserta_individu pi ON gi.idgame = pi.game_individu_idgame WHERE pi.win = (SELECT MAX(win)FROM game_individu) group by gi.nama_game;";
    let query = conn.query(sql,function(err,result){
        if (err) throw err;
        res.send(JSON.stringify({
            "status" : 200,
            "error" : null,
            "response" : result
        }));
    });
});



app.get('/TeamWin', function(req,res){
    console.log('Menerima GET request /Team-Win');
    let data = {win: req.body.win};
    let sql = "SELECT * FROM team t inner join peserta_kelompok pk on t.idteam = pk.team_idteam WHERE status = 1 AND win = '" + data.win + "';";
    let query = conn.query(sql,function(err,result){
        if (err) throw err;
        res.send(JSON.stringify({
            "status" : 200,
            "error" : null,
            "response" : result
        }));
    });
});

app.post('/insertAdmin',function(req,res){
    console.log('Menerima POST request /insertAdmin');
    console.log(req.body);
    let data = {username: req.body.username,
                password: req.body.password
                };
    let sql = "INSERT INTO admin (username,password) VALUES ('" + data.username + "','" + data.password + "')";
    let query = conn.query(sql,data,function(err,result){
        if (err) throw err;
        res.send(JSON.stringify(
            {
                "status" : 200,
                "error"  : null,
                "response" : result
            }
        ))
    });
});


app.post('/insertBracketIndividu', function(req, res) {
    console.log('Menerima POST request /insertBracketIndiv');
    console.log(req.body);
    let data = {
        idpeserta: req.body.idpeserta,
        idpeserta1: req.body.idpeserta1,
        date: req.body.date
    };
    let sql = "INSERT INTO `bracket_individu` (`idpeserta`, `idpeserta1`, `date`, `komentar`) VALUES ('" + data.idpeserta + "','" + data.idpeserta1 + "', '" + data.date + "', NULL);";
    let query = conn.query(sql, data, function(err, result) {
        if (err) throw err;

        // Update status peserta individu 1 menjadi 3
        let updateSql1 = "UPDATE `peserta_individu` SET `status` = '3' WHERE `peserta_individu`.`idpeserta` = " + data.idpeserta + ";";
        conn.query(updateSql1, function(updateErr1, updateResult1) {
            if (updateErr1) throw updateErr1;

            // Update status peserta individu 2 menjadi 3
            let updateSql2 = "UPDATE `peserta_individu` SET `status` = '3' WHERE `peserta_individu`.`idpeserta` = " + data.idpeserta1 + ";";
            conn.query(updateSql2, function(updateErr2, updateResult2) {
                if (updateErr2) throw updateErr2;

                res.send(JSON.stringify({
                    "status": 200,
                    "error": null,
                    "response": updateResult2
                }));
            });
        });
    });
});





app.post('/insertBracketTeam', function(req, res) {
    console.log('Menerima POST request /insertBracketTeam');
    console.log(req.body);
    let data = {
        idteam: req.body.idteam,
        idteam1: req.body.idteam1,
        date: req.body.date
    };
    let sql = "INSERT INTO `bracket_team` (`team_idteam`, `team_idteam1`, `date`, `komentar`) VALUES ('" + data.idteam + "','" + data.idteam1 + "', '" + data.date + "', NULL);";
    let query = conn.query(sql, data, function(err, result) {
        if (err) throw err;

        // Update status team 1 menjadi 3
        let updateSql1 = "UPDATE `team` SET `status` = '3' WHERE `team`.`idteam` = " + data.idteam + ";";
        conn.query(updateSql1, function(updateErr1, updateResult1) {
            if (updateErr1) throw updateErr1;

            // Update status team 2 menjadi 3
            let updateSql2 = "UPDATE `team` SET `status` = '3' WHERE `team`.`idteam` = " + data.idteam1 + ";";
            conn.query(updateSql2, function(updateErr2, updateResult2) {
                if (updateErr2) throw updateErr2;

                res.send(JSON.stringify({
                    "status": 200,
                    "error": null,
                    "response": updateResult2
                }));
            });
        });
    });
});



app.post('/insertGameIndividu',function(req,res){
    console.log('Menerima POST request /insertGameIndividu');
    console.log(req.body);
    let data = {nama_game: req.body.nama_game};
    let sql = "INSERT INTO game_individu (nama_game) VALUES ('" + data.nama_game + "')";
    let query = conn.query(sql,data,function(err,result){
        if (err) throw err;
        res.send(JSON.stringify(
            {
                "status" : 200,
                "error"  : null,
                "response" : result
            }
        ))
    });
});

app.post('/insertGameKelompok',function(req,res){
    console.log('Menerima POST request /insertGameKelompok');
    console.log(req.body);
    let data = {nama_game: req.body.nama_game};
    let sql = "INSERT INTO game_kelompok (nama_game) VALUES ('" + data.nama_game + "')";
    let query = conn.query(sql,data,function(err,result){
        if (err) throw err;
        res.send(JSON.stringify(
            {
                "status" : 200,
                "error"  : null,
                "response" : result
            }
        ))
    });
});

app.post('/insertPemain_individu',function(req,res){
    console.log('Menerima POST request /insertPemain_individu');
    console.log(req.body);
    let data = {nama: req.body.nama,
                alamat: req.body.alamat,
                tanggal_lahir: req.body.tanggal_lahir,
                no_handphone: req.body.no_handphone,
                nrp: req.body.nrp,
                program_studi: req.body.program_studi,
                angkatan: req.body.angkatan,
                idgame: req.body.idgame};
    let sql = "INSERT INTO peserta_individu (nama,alamat,tanggal_lahir,no_handphone,nrp,program_studi,angkatan,win,lose,game_individu_idgame,status) VALUES ('" + data.nama + "','" + data.alamat + "','" + data.tanggal_lahir + "','" + data.no_handphone + "','" + data.nrp + "','" + data.program_studi + "','" + data.angkatan + "',0,0,'" + data.idgame + "',0);";
    let query = conn.query(sql,data,function(err,result){
        if (err) throw err;
        res.send(JSON.stringify(
            {
                "status" : 200,
                "error"  : null,
                "response" : result
            }
        ))
    });
});

app.post('/insertTeam',function(req,res){
    console.log('Menerima POST request /insertTeam');
    console.log(req.body);
    let data = {nama_team: req.body.nama_team,
                idgame: req.body.idgame,
            password:req.body.password};
    let sql = "INSERT INTO team (nama_team,win,lose,game_kelompok_idgame,status,password) VALUES ('" + data.nama_team + "',0,0,'" + data.idgame + "',0,'"+data.password+"')";
    let query = conn.query(sql,data,function(err,result){
        if (err) throw err;
        res.send(JSON.stringify(
            {
                "status" : 200,
                "error"  : null,
                "response" : result
            }
        ))
    });
});



app.post('/insertPemain_kelompok',function(req,res){
    console.log('Menerima POST request /insertPemain_kelompok');
    console.log(req.body);
    let data = {nama: req.body.nama,
                alamat: req.body.alamat,
                tanggal_lahir: req.body.tanggal_lahir,
                no_handphone: req.body.no_handphone,
                nrp: req.body.nrp,
                program_studi: req.body.program_studi,
                angkatan: req.body.angkatan,
                idteam: req.body.idteam};
    let sql = "INSERT INTO peserta_kelompok (nama,alamat,tanggal_lahir,no_handphone,nrp,program_studi,angkatan,team_idteam) VALUES ('" + data.nama + "','" + data.alamat + "','" + data.tanggal_lahir + "','" + data.no_handphone + "','" + data.nrp + "','" + data.program_studi + "','" + data.angkatan + "','" + data.idteam + "');";
    let query = conn.query(sql,data,function(err,result){
        if (err) throw err;
        res.send(JSON.stringify(
            {
                "status" : 200,
                "error"  : null,
                "response" : result
            }
        ))
    });
});

app.post('/updateStatusDiterima', function(req,res){
    console.log('Menerima POST request /updateStatusPeserta_individu-Diterima');
    let data = { idpeserta: req.body.idpeserta};
    let sql = "UPDATE peserta_individu SET status = 1 WHERE idpeserta = "+ data.idpeserta +";";
    let query = conn.query(sql,function(err,result){
        if (err) throw err;
        res.send(JSON.stringify({
            "status" : 200,
            "error" : null,
            "response" : result
        }));
    });
});

app.post('/updateStatusTeamDiterima', function(req,res){
    console.log('Menerima POST request /updateStatusTeam-Diterima');
    let data = { idteam: req.body.idteam};
    let sql = "UPDATE team SET status = 1 WHERE idteam = "+ data.idteam +";";
    let query = conn.query(sql,function(err,result){
        if (err) throw err;
        res.send(JSON.stringify({
            "status" : 200,
            "error" : null,
            "response" : result
        }));
    });
});

app.post('/updateStatusTeamDitolak', function(req,res){
    console.log('Menerima POST request /updateStatusTeam-Ditolak');
    let data = { idteam: req.body.idteam};
    let sql = "UPDATE team SET status = 2 WHERE idteam = "+ data.idteam +";";
    let query = conn.query(sql,function(err,result){
        if (err) throw err;
        res.send(JSON.stringify({
            "status" : 200,
            "error" : null,
            "response" : result
        }));
    });
});

app.post('/updateTolakPeserta', function(req,res){
    console.log('Menerima POST request /updateStatusTeam-Ditolak');
    let data = { idpeserta: req.body.idpeserta};
    let sql = "UPDATE peserta_individu SET status = 2 WHERE idpeserta = "+ data.idpeserta +";";
    let query = conn.query(sql,function(err,result){
        if (err) throw err;
        res.send(JSON.stringify({
            "status" : 200,
            "error" : null,
            "response" : result
        }));
    });
});


app.post('/updateWinLosePeserta_individu', function(req,res){
    console.log('Menerima POST request /updateWinLosePeserta_individu');
    let data = { win: req.body.win,
                lose: req.body.lose,
                idpeserta: req.body.idpeserta};
    let sql = "UPDATE peserta_individu SET `win` = win+ '" + data.win + "', `lose` = lose +'" + data.lose + "' WHERE `peserta_individu`.`idpeserta` = '" + data.idpeserta + "';";

    let query = conn.query(sql,function(err,result){
        if (err) throw err;
        res.send(JSON.stringify({
            "status" : 200,
            "error" : null,
            "response" : result
        }));
    });
});

app.post('/updateWinLoseTeam', function(req,res){
    console.log('Menerima POST request /updateWinLoseTeam');
    let data = { win: req.body.win,
                lose: req.body.lose,
                idteam: req.body.idteam};
    let sql = "UPDATE team SET win = win + " + data.win + ", lose = lose + " + data.lose + " WHERE idteam = '"+ data.idteam +"';";
    let query = conn.query(sql,function(err,result){
        if (err) throw err;
        res.send(JSON.stringify({
            "status" : 200,
            "error" : null,
            "response" : result
        }));
    });
});

app.post('/login', function (req, res) {
    console.log('Menerima POST request /login');
    let data = { username: req.body.username,
        password: req.body.password};
  
    let sql = "SELECT * FROM admin WHERE username = '" + data.username + "' AND password = '" + data.password + "'";
  
    conn.query(sql, function (error, results) {
      if (error) {
        console.error('Error executing query:', error);
        res.status(500).json({ message: 'Internal server error' });
      } else {
        if (results.length > 0) {
          res.status(200).json({ message: 'Login successful' });
        } else {
          res.status(401).json({ message: 'Login failed' });
        }
      }
    });
  });

  app.post('/loginTeam', function (req, res) {
    console.log('Menerima POST request /login');
    let data = { 
        nama_team: req.body.nama_team,
        password: req.body.password
    };
  
    let sql = "SELECT * FROM team WHERE nama_team = '" + data.nama_team + "' AND password = '" + data.password + "'";
  
    conn.query(sql, function (error, results) {
        if (error) {
            console.error('Error executing query:', error);
            res.status(500).json({ message: 'Internal server error' });
        } else {
            if (results.length > 0) {
                const idteam = results[0].idteam; // mengambil id_team dari hasil query
                res.status(200).json({ 
                    message: 'Login successful',
                    idteam: idteam // menyertakan id_team pada respons
                });
            } else {
                res.status(401).json({ message: 'Login failed' });
            }
        }
    });
});

app.get('/bracketIndiv', function(req,res){
    console.log('Menerima GET request /bracketIndiv');
    let sql = "SELECT p1.nama AS peserta1, p2.nama AS peserta2, b.date, b.komentar FROM bracket_individu b   JOIN peserta_individu p1 ON b.idpeserta = p1.idpeserta JOIN peserta_individu p2 ON b.idpeserta1 = p2.idpeserta   WHERE b.idpeserta IS NOT NULL AND b.idpeserta1 IS NOT NULL;";
    let query = conn.query(sql,function(err,result){
        if (err) throw err;
        res.send(JSON.stringify({
            "status" : 200,
            "error" : null,
            "response" : result
        }));
    });
});

app.get('/bracketTeam', function(req,res){
    console.log('Menerima GET request /bracketTeam');
    let sql = "SELECT t1.nama_team AS team1, t2.nama_team AS team2, bt.date, bt.komentar    FROM bracket_team bt    JOIN team t1 ON bt.team_idteam = t1.idteam   JOIN team t2 ON bt.team_idteam1 = t2.idteam;";
    let query = conn.query(sql,function(err,result){
        if (err) throw err;
        res.send(JSON.stringify({
            "status" : 200,
            "error" : null,
            "response" : result
        }));
    });
});


var server = app.listen(7000,function(){
    var host = server.address().address;
    var port = server.address().port;
    console.log("Express app listening at http://%s:%s", host,port);
});
