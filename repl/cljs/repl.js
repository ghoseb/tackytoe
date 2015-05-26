// Compiled by ClojureScript 0.0-3297 {}
goog.provide('cljs.repl');
goog.require('cljs.core');
cljs.repl.print_doc = (function cljs$repl$print_doc(m){
cljs.core.println.call(null,"-------------------------");

cljs.core.println.call(null,[cljs.core.str((function (){var temp__4423__auto__ = new cljs.core.Keyword(null,"ns","ns",441598760).cljs$core$IFn$_invoke$arity$1(m);
if(cljs.core.truth_(temp__4423__auto__)){
var ns = temp__4423__auto__;
return [cljs.core.str(ns),cljs.core.str("/")].join('');
} else {
return null;
}
})()),cljs.core.str(new cljs.core.Keyword(null,"name","name",1843675177).cljs$core$IFn$_invoke$arity$1(m))].join(''));

if(cljs.core.truth_(new cljs.core.Keyword(null,"protocol","protocol",652470118).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"Protocol");
} else {
}

if(cljs.core.truth_(new cljs.core.Keyword(null,"forms","forms",2045992350).cljs$core$IFn$_invoke$arity$1(m))){
var seq__11342_11354 = cljs.core.seq.call(null,new cljs.core.Keyword(null,"forms","forms",2045992350).cljs$core$IFn$_invoke$arity$1(m));
var chunk__11343_11355 = null;
var count__11344_11356 = (0);
var i__11345_11357 = (0);
while(true){
if((i__11345_11357 < count__11344_11356)){
var f_11358 = cljs.core._nth.call(null,chunk__11343_11355,i__11345_11357);
cljs.core.println.call(null,"  ",f_11358);

var G__11359 = seq__11342_11354;
var G__11360 = chunk__11343_11355;
var G__11361 = count__11344_11356;
var G__11362 = (i__11345_11357 + (1));
seq__11342_11354 = G__11359;
chunk__11343_11355 = G__11360;
count__11344_11356 = G__11361;
i__11345_11357 = G__11362;
continue;
} else {
var temp__4423__auto___11363 = cljs.core.seq.call(null,seq__11342_11354);
if(temp__4423__auto___11363){
var seq__11342_11364__$1 = temp__4423__auto___11363;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__11342_11364__$1)){
var c__5640__auto___11365 = cljs.core.chunk_first.call(null,seq__11342_11364__$1);
var G__11366 = cljs.core.chunk_rest.call(null,seq__11342_11364__$1);
var G__11367 = c__5640__auto___11365;
var G__11368 = cljs.core.count.call(null,c__5640__auto___11365);
var G__11369 = (0);
seq__11342_11354 = G__11366;
chunk__11343_11355 = G__11367;
count__11344_11356 = G__11368;
i__11345_11357 = G__11369;
continue;
} else {
var f_11370 = cljs.core.first.call(null,seq__11342_11364__$1);
cljs.core.println.call(null,"  ",f_11370);

var G__11371 = cljs.core.next.call(null,seq__11342_11364__$1);
var G__11372 = null;
var G__11373 = (0);
var G__11374 = (0);
seq__11342_11354 = G__11371;
chunk__11343_11355 = G__11372;
count__11344_11356 = G__11373;
i__11345_11357 = G__11374;
continue;
}
} else {
}
}
break;
}
} else {
if(cljs.core.truth_(new cljs.core.Keyword(null,"arglists","arglists",1661989754).cljs$core$IFn$_invoke$arity$1(m))){
var arglists_11375 = new cljs.core.Keyword(null,"arglists","arglists",1661989754).cljs$core$IFn$_invoke$arity$1(m);
if(cljs.core.truth_((function (){var or__4855__auto__ = new cljs.core.Keyword(null,"macro","macro",-867863404).cljs$core$IFn$_invoke$arity$1(m);
if(cljs.core.truth_(or__4855__auto__)){
return or__4855__auto__;
} else {
return new cljs.core.Keyword(null,"repl-special-function","repl-special-function",1262603725).cljs$core$IFn$_invoke$arity$1(m);
}
})())){
cljs.core.prn.call(null,arglists_11375);
} else {
cljs.core.prn.call(null,((cljs.core._EQ_.call(null,new cljs.core.Symbol(null,"quote","quote",1377916282,null),cljs.core.first.call(null,arglists_11375)))?cljs.core.second.call(null,arglists_11375):arglists_11375));
}
} else {
}
}

if(cljs.core.truth_(new cljs.core.Keyword(null,"special-form","special-form",-1326536374).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"Special Form");

cljs.core.println.call(null," ",new cljs.core.Keyword(null,"doc","doc",1913296891).cljs$core$IFn$_invoke$arity$1(m));

if(cljs.core.contains_QMARK_.call(null,m,new cljs.core.Keyword(null,"url","url",276297046))){
if(cljs.core.truth_(new cljs.core.Keyword(null,"url","url",276297046).cljs$core$IFn$_invoke$arity$1(m))){
return cljs.core.println.call(null,[cljs.core.str("\n  Please see http://clojure.org/"),cljs.core.str(new cljs.core.Keyword(null,"url","url",276297046).cljs$core$IFn$_invoke$arity$1(m))].join(''));
} else {
return null;
}
} else {
return cljs.core.println.call(null,[cljs.core.str("\n  Please see http://clojure.org/special_forms#"),cljs.core.str(new cljs.core.Keyword(null,"name","name",1843675177).cljs$core$IFn$_invoke$arity$1(m))].join(''));
}
} else {
if(cljs.core.truth_(new cljs.core.Keyword(null,"macro","macro",-867863404).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"Macro");
} else {
}

if(cljs.core.truth_(new cljs.core.Keyword(null,"repl-special-function","repl-special-function",1262603725).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"REPL Special Function");
} else {
}

cljs.core.println.call(null," ",new cljs.core.Keyword(null,"doc","doc",1913296891).cljs$core$IFn$_invoke$arity$1(m));

if(cljs.core.truth_(new cljs.core.Keyword(null,"protocol","protocol",652470118).cljs$core$IFn$_invoke$arity$1(m))){
var seq__11346 = cljs.core.seq.call(null,new cljs.core.Keyword(null,"methods","methods",453930866).cljs$core$IFn$_invoke$arity$1(m));
var chunk__11347 = null;
var count__11348 = (0);
var i__11349 = (0);
while(true){
if((i__11349 < count__11348)){
var vec__11350 = cljs.core._nth.call(null,chunk__11347,i__11349);
var name = cljs.core.nth.call(null,vec__11350,(0),null);
var map__11351 = cljs.core.nth.call(null,vec__11350,(1),null);
var map__11351__$1 = ((cljs.core.seq_QMARK_.call(null,map__11351))?cljs.core.apply.call(null,cljs.core.hash_map,map__11351):map__11351);
var doc = cljs.core.get.call(null,map__11351__$1,new cljs.core.Keyword(null,"doc","doc",1913296891));
var arglists = cljs.core.get.call(null,map__11351__$1,new cljs.core.Keyword(null,"arglists","arglists",1661989754));
cljs.core.println.call(null);

cljs.core.println.call(null," ",name);

cljs.core.println.call(null," ",arglists);

if(cljs.core.truth_(doc)){
cljs.core.println.call(null," ",doc);
} else {
}

var G__11376 = seq__11346;
var G__11377 = chunk__11347;
var G__11378 = count__11348;
var G__11379 = (i__11349 + (1));
seq__11346 = G__11376;
chunk__11347 = G__11377;
count__11348 = G__11378;
i__11349 = G__11379;
continue;
} else {
var temp__4423__auto__ = cljs.core.seq.call(null,seq__11346);
if(temp__4423__auto__){
var seq__11346__$1 = temp__4423__auto__;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__11346__$1)){
var c__5640__auto__ = cljs.core.chunk_first.call(null,seq__11346__$1);
var G__11380 = cljs.core.chunk_rest.call(null,seq__11346__$1);
var G__11381 = c__5640__auto__;
var G__11382 = cljs.core.count.call(null,c__5640__auto__);
var G__11383 = (0);
seq__11346 = G__11380;
chunk__11347 = G__11381;
count__11348 = G__11382;
i__11349 = G__11383;
continue;
} else {
var vec__11352 = cljs.core.first.call(null,seq__11346__$1);
var name = cljs.core.nth.call(null,vec__11352,(0),null);
var map__11353 = cljs.core.nth.call(null,vec__11352,(1),null);
var map__11353__$1 = ((cljs.core.seq_QMARK_.call(null,map__11353))?cljs.core.apply.call(null,cljs.core.hash_map,map__11353):map__11353);
var doc = cljs.core.get.call(null,map__11353__$1,new cljs.core.Keyword(null,"doc","doc",1913296891));
var arglists = cljs.core.get.call(null,map__11353__$1,new cljs.core.Keyword(null,"arglists","arglists",1661989754));
cljs.core.println.call(null);

cljs.core.println.call(null," ",name);

cljs.core.println.call(null," ",arglists);

if(cljs.core.truth_(doc)){
cljs.core.println.call(null," ",doc);
} else {
}

var G__11384 = cljs.core.next.call(null,seq__11346__$1);
var G__11385 = null;
var G__11386 = (0);
var G__11387 = (0);
seq__11346 = G__11384;
chunk__11347 = G__11385;
count__11348 = G__11386;
i__11349 = G__11387;
continue;
}
} else {
return null;
}
}
break;
}
} else {
return null;
}
}
});
