<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!doctype html>
<html lang="en">
<head>
	
	<title>Register Company</title>
	
  
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  
  <!-- Reference Bootstrap files -->
  <link rel="stylesheet"
     href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  @charset "UTF-8";
@import url(font-awesome.min.css);
@import "https://fonts.googleapis.com/css?family=Montserrat:700|Open+Sans:300,400|Pacifico";

/*
	Intensify by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
*/

/* Reset */

	html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn, em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var, b, u, i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend, table, caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas, details, embed, figure, figcaption, footer, header, hgroup, menu, nav, output, ruby, section, summary, time, mark, audio, video {
		margin: 0;
		padding: 0;
		border: 0;
		font-size: 100%;
		font: inherit;
		vertical-align: baseline;
	}

	article, aside, details, figcaption, figure, footer, header, hgroup, menu, nav, section {
		display: block;
	}

	body {
		line-height: 1;
	}

	ol, ul {
		list-style: none;
	}

	blockquote, q {
		quotes: none;
	}

	blockquote:before, blockquote:after, q:before, q:after {
		content: '';
		content: none;
	}

	table {
		border-collapse: collapse;
		border-spacing: 0;
	}

	body {
		-webkit-text-size-adjust: none;
	}

/* Box Model */

	*, *:before, *:after {
		-moz-box-sizing: border-box;
		-webkit-box-sizing: border-box;
		box-sizing: border-box;
	}

/* Containers */

	.container {
		margin-left: auto;
		margin-right: auto;
	}

	.container.\31 25\25 {
		width: 100%;
		max-width: 100em;
		min-width: 80em;
	}

	.container.\37 5\25 {
		width: 60em;
	}

	.container.\35 0\25 {
		width: 40em;
	}

	.container.\32 5\25 {
		width: 20em;
	}

	.container {
		width: 80em;
	}

	@media screen and (max-width: 1680px) {

		.container.\31 25\25 {
			width: 100%;
			max-width: 100em;
			min-width: 80em;
		}

		.container.\37 5\25 {
			width: 60em;
		}

		.container.\35 0\25 {
			width: 40em;
		}

		.container.\32 5\25 {
			width: 20em;
		}

		.container {
			width: 80em;
		}

	}

	@media screen and (max-width: 1280px) {

		.container.\31 25\25 {
			width: 100%;
			max-width: 81.25em;
			min-width: 65em;
		}

		.container.\37 5\25 {
			width: 48.75em;
		}

		.container.\35 0\25 {
			width: 32.5em;
		}

		.container.\32 5\25 {
			width: 16.25em;
		}

		.container {
			width: 65em;
		}

	}

	@media screen and (max-width: 980px) {

		.container.\31 25\25 {
			width: 100%;
			max-width: 112.5%;
			min-width: 90%;
		}

		.container.\37 5\25 {
			width: 67.5%;
		}

		.container.\35 0\25 {
			width: 45%;
		}

		.container.\32 5\25 {
			width: 22.5%;
		}

		.container {
			width: 90%;
		}

	}

	@media screen and (max-width: 736px) {

		.container.\31 25\25 {
			width: 100%;
			max-width: 112.5%;
			min-width: 90%;
		}

		.container.\37 5\25 {
			width: 67.5%;
		}

		.container.\35 0\25 {
			width: 45%;
		}

		.container.\32 5\25 {
			width: 22.5%;
		}

		.container {
			width: 90% !important;
		}

	}

	@media screen and (max-width: 480px) {

		.container.\31 25\25 {
			width: 100%;
			max-width: 112.5%;
			min-width: 90%;
		}

		.container.\37 5\25 {
			width: 67.5%;
		}

		.container.\35 0\25 {
			width: 45%;
		}

		.container.\32 5\25 {
			width: 22.5%;
		}

		.container {
			width: 90% !important;
		}

	}

/* Grid */

	.row {
		border-bottom: solid 1px transparent;
		-moz-box-sizing: border-box;
		-webkit-box-sizing: border-box;
		box-sizing: border-box;
	}

	.row > * {
		float: left;
		-moz-box-sizing: border-box;
		-webkit-box-sizing: border-box;
		box-sizing: border-box;
	}

	.row:after, .row:before {
		content: '';
		display: block;
		clear: both;
		height: 0;
	}

	.row.uniform > * > :first-child {
		margin-top: 0;
	}

	.row.uniform > * > :last-child {
		margin-bottom: 0;
	}

	.row.\30 \25 > * {
		padding: 0 0 0 0em;
	}

	.row.\30 \25 {
		margin: 0 0 -1px 0em;
	}

	.row.uniform.\30 \25 > * {
		padding: 0em 0 0 0em;
	}

	.row.uniform.\30 \25 {
		margin: 0em 0 -1px 0em;
	}

	.row > * {
		padding: 0 0 0 2em;
	}

	.row {
		margin: 0 0 -1px -2em;
	}

	.row.uniform > * {
		padding: 2em 0 0 2em;
	}

	.row.uniform {
		margin: -2em 0 -1px -2em;
	}

	.row.\32 00\25 > * {
		padding: 0 0 0 4em;
	}

	.row.\32 00\25 {
		margin: 0 0 -1px -4em;
	}

	.row.uniform.\32 00\25 > * {
		padding: 4em 0 0 4em;
	}

	.row.uniform.\32 00\25 {
		margin: -4em 0 -1px -4em;
	}

	.row.\31 50\25 > * {
		padding: 0 0 0 3em;
	}

	.row.\31 50\25 {
		margin: 0 0 -1px -3em;
	}

	.row.uniform.\31 50\25 > * {
		padding: 3em 0 0 3em;
	}

	.row.uniform.\31 50\25 {
		margin: -3em 0 -1px -3em;
	}

	.row.\35 0\25 > * {
		padding: 0 0 0 1em;
	}

	.row.\35 0\25 {
		margin: 0 0 -1px -1em;
	}

	.row.uniform.\35 0\25 > * {
		padding: 1em 0 0 1em;
	}

	.row.uniform.\35 0\25 {
		margin: -1em 0 -1px -1em;
	}

	.row.\32 5\25 > * {
		padding: 0 0 0 0.5em;
	}

	.row.\32 5\25 {
		margin: 0 0 -1px -0.5em;
	}

	.row.uniform.\32 5\25 > * {
		padding: 0.5em 0 0 0.5em;
	}

	.row.uniform.\32 5\25 {
		margin: -0.5em 0 -1px -0.5em;
	}

	.\31 2u, .\31 2u\24 {
		width: 100%;
		clear: none;
		margin-left: 0;
	}

	.\31 1u, .\31 1u\24 {
		width: 91.6666666667%;
		clear: none;
		margin-left: 0;
	}

	.\31 0u, .\31 0u\24 {
		width: 83.3333333333%;
		clear: none;
		margin-left: 0;
	}

	.\39 u, .\39 u\24 {
		width: 75%;
		clear: none;
		margin-left: 0;
	}

	.\38 u, .\38 u\24 {
		width: 66.6666666667%;
		clear: none;
		margin-left: 0;
	}

	.\37 u, .\37 u\24 {
		width: 58.3333333333%;
		clear: none;
		margin-left: 0;
	}

	.\36 u, .\36 u\24 {
		width: 50%;
		clear: none;
		margin-left: 0;
	}

	.\35 u, .\35 u\24 {
		width: 41.6666666667%;
		clear: none;
		margin-left: 0;
	}

	.\34 u, .\34 u\24 {
		width: 33.3333333333%;
		clear: none;
		margin-left: 0;
	}

	.\33 u, .\33 u\24 {
		width: 25%;
		clear: none;
		margin-left: 0;
	}

	.\32 u, .\32 u\24 {
		width: 16.6666666667%;
		clear: none;
		margin-left: 0;
	}

	.\31 u, .\31 u\24 {
		width: 8.3333333333%;
		clear: none;
		margin-left: 0;
	}

	.\31 2u\24 + *,
	.\31 1u\24 + *,
	.\31 0u\24 + *,
	.\39 u\24 + *,
	.\38 u\24 + *,
	.\37 u\24 + *,
	.\36 u\24 + *,
	.\35 u\24 + *,
	.\34 u\24 + *,
	.\33 u\24 + *,
	.\32 u\24 + *,
	.\31 u\24 + * {
		clear: left;
	}

	.\-11u {
		margin-left: 91.66667%;
	}

	.\-10u {
		margin-left: 83.33333%;
	}

	.\-9u {
		margin-left: 75%;
	}

	.\-8u {
		margin-left: 66.66667%;
	}

	.\-7u {
		margin-left: 58.33333%;
	}

	.\-6u {
		margin-left: 50%;
	}

	.\-5u {
		margin-left: 41.66667%;
	}

	.\-4u {
		margin-left: 33.33333%;
	}

	.\-3u {
		margin-left: 25%;
	}

	.\-2u {
		margin-left: 16.66667%;
	}

	.\-1u {
		margin-left: 8.33333%;
	}

	@media screen and (max-width: 1680px) {

		.row > * {
			padding: 0 0 0 2em;
		}

		.row {
			margin: 0 0 -1px -2em;
		}

		.row.uniform > * {
			padding: 2em 0 0 2em;
		}

		.row.uniform {
			margin: -2em 0 -1px -2em;
		}

		.row.\32 00\25 > * {
			padding: 0 0 0 4em;
		}

		.row.\32 00\25 {
			margin: 0 0 -1px -4em;
		}

		.row.uniform.\32 00\25 > * {
			padding: 4em 0 0 4em;
		}

		.row.uniform.\32 00\25 {
			margin: -4em 0 -1px -4em;
		}

		.row.\31 50\25 > * {
			padding: 0 0 0 3em;
		}

		.row.\31 50\25 {
			margin: 0 0 -1px -3em;
		}

		.row.uniform.\31 50\25 > * {
			padding: 3em 0 0 3em;
		}

		.row.uniform.\31 50\25 {
			margin: -3em 0 -1px -3em;
		}

		.row.\35 0\25 > * {
			padding: 0 0 0 1em;
		}

		.row.\35 0\25 {
			margin: 0 0 -1px -1em;
		}

		.row.uniform.\35 0\25 > * {
			padding: 1em 0 0 1em;
		}

		.row.uniform.\35 0\25 {
			margin: -1em 0 -1px -1em;
		}

		.row.\32 5\25 > * {
			padding: 0 0 0 0.5em;
		}

		.row.\32 5\25 {
			margin: 0 0 -1px -0.5em;
		}

		.row.uniform.\32 5\25 > * {
			padding: 0.5em 0 0 0.5em;
		}

		.row.uniform.\32 5\25 {
			margin: -0.5em 0 -1px -0.5em;
		}

		.\31 2u\28xlarge\29, .\31 2u\24\28xlarge\29 {
			width: 100%;
			clear: none;
			margin-left: 0;
		}

		.\31 1u\28xlarge\29, .\31 1u\24\28xlarge\29 {
			width: 91.6666666667%;
			clear: none;
			margin-left: 0;
		}

		.\31 0u\28xlarge\29, .\31 0u\24\28xlarge\29 {
			width: 83.3333333333%;
			clear: none;
			margin-left: 0;
		}

		.\39 u\28xlarge\29, .\39 u\24\28xlarge\29 {
			width: 75%;
			clear: none;
			margin-left: 0;
		}

		.\38 u\28xlarge\29, .\38 u\24\28xlarge\29 {
			width: 66.6666666667%;
			clear: none;
			margin-left: 0;
		}

		.\37 u\28xlarge\29, .\37 u\24\28xlarge\29 {
			width: 58.3333333333%;
			clear: none;
			margin-left: 0;
		}

		.\36 u\28xlarge\29, .\36 u\24\28xlarge\29 {
			width: 50%;
			clear: none;
			margin-left: 0;
		}

		.\35 u\28xlarge\29, .\35 u\24\28xlarge\29 {
			width: 41.6666666667%;
			clear: none;
			margin-left: 0;
		}

		.\34 u\28xlarge\29, .\34 u\24\28xlarge\29 {
			width: 33.3333333333%;
			clear: none;
			margin-left: 0;
		}

		.\33 u\28xlarge\29, .\33 u\24\28xlarge\29 {
			width: 25%;
			clear: none;
			margin-left: 0;
		}

		.\32 u\28xlarge\29, .\32 u\24\28xlarge\29 {
			width: 16.6666666667%;
			clear: none;
			margin-left: 0;
		}

		.\31 u\28xlarge\29, .\31 u\24\28xlarge\29 {
			width: 8.3333333333%;
			clear: none;
			margin-left: 0;
		}

		.\31 2u\24\28xlarge\29 + *,
		.\31 1u\24\28xlarge\29 + *,
		.\31 0u\24\28xlarge\29 + *,
		.\39 u\24\28xlarge\29 + *,
		.\38 u\24\28xlarge\29 + *,
		.\37 u\24\28xlarge\29 + *,
		.\36 u\24\28xlarge\29 + *,
		.\35 u\24\28xlarge\29 + *,
		.\34 u\24\28xlarge\29 + *,
		.\33 u\24\28xlarge\29 + *,
		.\32 u\24\28xlarge\29 + *,
		.\31 u\24\28xlarge\29 + * {
			clear: left;
		}

		.\-11u\28xlarge\29 {
			margin-left: 91.66667%;
		}

		.\-10u\28xlarge\29 {
			margin-left: 83.33333%;
		}

		.\-9u\28xlarge\29 {
			margin-left: 75%;
		}

		.\-8u\28xlarge\29 {
			margin-left: 66.66667%;
		}

		.\-7u\28xlarge\29 {
			margin-left: 58.33333%;
		}

		.\-6u\28xlarge\29 {
			margin-left: 50%;
		}

		.\-5u\28xlarge\29 {
			margin-left: 41.66667%;
		}

		.\-4u\28xlarge\29 {
			margin-left: 33.33333%;
		}

		.\-3u\28xlarge\29 {
			margin-left: 25%;
		}

		.\-2u\28xlarge\29 {
			margin-left: 16.66667%;
		}

		.\-1u\28xlarge\29 {
			margin-left: 8.33333%;
		}

	}

	@media screen and (max-width: 1280px) {

		.row > * {
			padding: 0 0 0 1.5em;
		}

		.row {
			margin: 0 0 -1px -1.5em;
		}

		.row.uniform > * {
			padding: 1.5em 0 0 1.5em;
		}

		.row.uniform {
			margin: -1.5em 0 -1px -1.5em;
		}

		.row.\32 00\25 > * {
			padding: 0 0 0 3em;
		}

		.row.\32 00\25 {
			margin: 0 0 -1px -3em;
		}

		.row.uniform.\32 00\25 > * {
			padding: 3em 0 0 3em;
		}

		.row.uniform.\32 00\25 {
			margin: -3em 0 -1px -3em;
		}

		.row.\31 50\25 > * {
			padding: 0 0 0 2.25em;
		}

		.row.\31 50\25 {
			margin: 0 0 -1px -2.25em;
		}

		.row.uniform.\31 50\25 > * {
			padding: 2.25em 0 0 2.25em;
		}

		.row.uniform.\31 50\25 {
			margin: -2.25em 0 -1px -2.25em;
		}

		.row.\35 0\25 > * {
			padding: 0 0 0 0.75em;
		}

		.row.\35 0\25 {
			margin: 0 0 -1px -0.75em;
		}

		.row.uniform.\35 0\25 > * {
			padding: 0.75em 0 0 0.75em;
		}

		.row.uniform.\35 0\25 {
			margin: -0.75em 0 -1px -0.75em;
		}

		.row.\32 5\25 > * {
			padding: 0 0 0 0.375em;
		}

		.row.\32 5\25 {
			margin: 0 0 -1px -0.375em;
		}

		.row.uniform.\32 5\25 > * {
			padding: 0.375em 0 0 0.375em;
		}

		.row.uniform.\32 5\25 {
			margin: -0.375em 0 -1px -0.375em;
		}

		.\31 2u\28large\29, .\31 2u\24\28large\29 {
			width: 100%;
			clear: none;
			margin-left: 0;
		}

		.\31 1u\28large\29, .\31 1u\24\28large\29 {
			width: 91.6666666667%;
			clear: none;
			margin-left: 0;
		}

		.\31 0u\28large\29, .\31 0u\24\28large\29 {
			width: 83.3333333333%;
			clear: none;
			margin-left: 0;
		}

		.\39 u\28large\29, .\39 u\24\28large\29 {
			width: 75%;
			clear: none;
			margin-left: 0;
		}

		.\38 u\28large\29, .\38 u\24\28large\29 {
			width: 66.6666666667%;
			clear: none;
			margin-left: 0;
		}

		.\37 u\28large\29, .\37 u\24\28large\29 {
			width: 58.3333333333%;
			clear: none;
			margin-left: 0;
		}

		.\36 u\28large\29, .\36 u\24\28large\29 {
			width: 50%;
			clear: none;
			margin-left: 0;
		}

		.\35 u\28large\29, .\35 u\24\28large\29 {
			width: 41.6666666667%;
			clear: none;
			margin-left: 0;
		}

		.\34 u\28large\29, .\34 u\24\28large\29 {
			width: 33.3333333333%;
			clear: none;
			margin-left: 0;
		}

		.\33 u\28large\29, .\33 u\24\28large\29 {
			width: 25%;
			clear: none;
			margin-left: 0;
		}

		.\32 u\28large\29, .\32 u\24\28large\29 {
			width: 16.6666666667%;
			clear: none;
			margin-left: 0;
		}

		.\31 u\28large\29, .\31 u\24\28large\29 {
			width: 8.3333333333%;
			clear: none;
			margin-left: 0;
		}

		.\31 2u\24\28large\29 + *,
		.\31 1u\24\28large\29 + *,
		.\31 0u\24\28large\29 + *,
		.\39 u\24\28large\29 + *,
		.\38 u\24\28large\29 + *,
		.\37 u\24\28large\29 + *,
		.\36 u\24\28large\29 + *,
		.\35 u\24\28large\29 + *,
		.\34 u\24\28large\29 + *,
		.\33 u\24\28large\29 + *,
		.\32 u\24\28large\29 + *,
		.\31 u\24\28large\29 + * {
			clear: left;
		}

		.\-11u\28large\29 {
			margin-left: 91.66667%;
		}

		.\-10u\28large\29 {
			margin-left: 83.33333%;
		}

		.\-9u\28large\29 {
			margin-left: 75%;
		}

		.\-8u\28large\29 {
			margin-left: 66.66667%;
		}

		.\-7u\28large\29 {
			margin-left: 58.33333%;
		}

		.\-6u\28large\29 {
			margin-left: 50%;
		}

		.\-5u\28large\29 {
			margin-left: 41.66667%;
		}

		.\-4u\28large\29 {
			margin-left: 33.33333%;
		}

		.\-3u\28large\29 {
			margin-left: 25%;
		}

		.\-2u\28large\29 {
			margin-left: 16.66667%;
		}

		.\-1u\28large\29 {
			margin-left: 8.33333%;
		}

	}

	@media screen and (max-width: 980px) {

		.row > * {
			padding: 0 0 0 1.5em;
		}

		.row {
			margin: 0 0 -1px -1.5em;
		}

		.row.uniform > * {
			padding: 1.5em 0 0 1.5em;
		}

		.row.uniform {
			margin: -1.5em 0 -1px -1.5em;
		}

		.row.\32 00\25 > * {
			padding: 0 0 0 3em;
		}

		.row.\32 00\25 {
			margin: 0 0 -1px -3em;
		}

		.row.uniform.\32 00\25 > * {
			padding: 3em 0 0 3em;
		}

		.row.uniform.\32 00\25 {
			margin: -3em 0 -1px -3em;
		}

		.row.\31 50\25 > * {
			padding: 0 0 0 2.25em;
		}

		.row.\31 50\25 {
			margin: 0 0 -1px -2.25em;
		}

		.row.uniform.\31 50\25 > * {
			padding: 2.25em 0 0 2.25em;
		}

		.row.uniform.\31 50\25 {
			margin: -2.25em 0 -1px -2.25em;
		}

		.row.\35 0\25 > * {
			padding: 0 0 0 0.75em;
		}

		.row.\35 0\25 {
			margin: 0 0 -1px -0.75em;
		}

		.row.uniform.\35 0\25 > * {
			padding: 0.75em 0 0 0.75em;
		}

		.row.uniform.\35 0\25 {
			margin: -0.75em 0 -1px -0.75em;
		}

		.row.\32 5\25 > * {
			padding: 0 0 0 0.375em;
		}

		.row.\32 5\25 {
			margin: 0 0 -1px -0.375em;
		}

		.row.uniform.\32 5\25 > * {
			padding: 0.375em 0 0 0.375em;
		}

		.row.uniform.\32 5\25 {
			margin: -0.375em 0 -1px -0.375em;
		}

		.\31 2u\28medium\29, .\31 2u\24\28medium\29 {
			width: 100%;
			clear: none;
			margin-left: 0;
		}

		.\31 1u\28medium\29, .\31 1u\24\28medium\29 {
			width: 91.6666666667%;
			clear: none;
			margin-left: 0;
		}

		.\31 0u\28medium\29, .\31 0u\24\28medium\29 {
			width: 83.3333333333%;
			clear: none;
			margin-left: 0;
		}

		.\39 u\28medium\29, .\39 u\24\28medium\29 {
			width: 75%;
			clear: none;
			margin-left: 0;
		}

		.\38 u\28medium\29, .\38 u\24\28medium\29 {
			width: 66.6666666667%;
			clear: none;
			margin-left: 0;
		}

		.\37 u\28medium\29, .\37 u\24\28medium\29 {
			width: 58.3333333333%;
			clear: none;
			margin-left: 0;
		}

		.\36 u\28medium\29, .\36 u\24\28medium\29 {
			width: 50%;
			clear: none;
			margin-left: 0;
		}

		.\35 u\28medium\29, .\35 u\24\28medium\29 {
			width: 41.6666666667%;
			clear: none;
			margin-left: 0;
		}

		.\34 u\28medium\29, .\34 u\24\28medium\29 {
			width: 33.3333333333%;
			clear: none;
			margin-left: 0;
		}

		.\33 u\28medium\29, .\33 u\24\28medium\29 {
			width: 25%;
			clear: none;
			margin-left: 0;
		}

		.\32 u\28medium\29, .\32 u\24\28medium\29 {
			width: 16.6666666667%;
			clear: none;
			margin-left: 0;
		}

		.\31 u\28medium\29, .\31 u\24\28medium\29 {
			width: 8.3333333333%;
			clear: none;
			margin-left: 0;
		}

		.\31 2u\24\28medium\29 + *,
		.\31 1u\24\28medium\29 + *,
		.\31 0u\24\28medium\29 + *,
		.\39 u\24\28medium\29 + *,
		.\38 u\24\28medium\29 + *,
		.\37 u\24\28medium\29 + *,
		.\36 u\24\28medium\29 + *,
		.\35 u\24\28medium\29 + *,
		.\34 u\24\28medium\29 + *,
		.\33 u\24\28medium\29 + *,
		.\32 u\24\28medium\29 + *,
		.\31 u\24\28medium\29 + * {
			clear: left;
		}

		.\-11u\28medium\29 {
			margin-left: 91.66667%;
		}

		.\-10u\28medium\29 {
			margin-left: 83.33333%;
		}

		.\-9u\28medium\29 {
			margin-left: 75%;
		}

		.\-8u\28medium\29 {
			margin-left: 66.66667%;
		}

		.\-7u\28medium\29 {
			margin-left: 58.33333%;
		}

		.\-6u\28medium\29 {
			margin-left: 50%;
		}

		.\-5u\28medium\29 {
			margin-left: 41.66667%;
		}

		.\-4u\28medium\29 {
			margin-left: 33.33333%;
		}

		.\-3u\28medium\29 {
			margin-left: 25%;
		}

		.\-2u\28medium\29 {
			margin-left: 16.66667%;
		}

		.\-1u\28medium\29 {
			margin-left: 8.33333%;
		}

	}

	@media screen and (max-width: 736px) {

		.row > * {
			padding: 0 0 0 1.25em;
		}

		.row {
			margin: 0 0 -1px -1.25em;
		}

		.row.uniform > * {
			padding: 1.25em 0 0 1.25em;
		}

		.row.uniform {
			margin: -1.25em 0 -1px -1.25em;
		}

		.row.\32 00\25 > * {
			padding: 0 0 0 2.5em;
		}

		.row.\32 00\25 {
			margin: 0 0 -1px -2.5em;
		}

		.row.uniform.\32 00\25 > * {
			padding: 2.5em 0 0 2.5em;
		}

		.row.uniform.\32 00\25 {
			margin: -2.5em 0 -1px -2.5em;
		}

		.row.\31 50\25 > * {
			padding: 0 0 0 1.875em;
		}

		.row.\31 50\25 {
			margin: 0 0 -1px -1.875em;
		}

		.row.uniform.\31 50\25 > * {
			padding: 1.875em 0 0 1.875em;
		}

		.row.uniform.\31 50\25 {
			margin: -1.875em 0 -1px -1.875em;
		}

		.row.\35 0\25 > * {
			padding: 0 0 0 0.625em;
		}

		.row.\35 0\25 {
			margin: 0 0 -1px -0.625em;
		}

		.row.uniform.\35 0\25 > * {
			padding: 0.625em 0 0 0.625em;
		}

		.row.uniform.\35 0\25 {
			margin: -0.625em 0 -1px -0.625em;
		}

		.row.\32 5\25 > * {
			padding: 0 0 0 0.3125em;
		}

		.row.\32 5\25 {
			margin: 0 0 -1px -0.3125em;
		}

		.row.uniform.\32 5\25 > * {
			padding: 0.3125em 0 0 0.3125em;
		}

		.row.uniform.\32 5\25 {
			margin: -0.3125em 0 -1px -0.3125em;
		}

		.\31 2u\28small\29, .\31 2u\24\28small\29 {
			width: 100%;
			clear: none;
			margin-left: 0;
		}

		.\31 1u\28small\29, .\31 1u\24\28small\29 {
			width: 91.6666666667%;
			clear: none;
			margin-left: 0;
		}

		.\31 0u\28small\29, .\31 0u\24\28small\29 {
			width: 83.3333333333%;
			clear: none;
			margin-left: 0;
		}

		.\39 u\28small\29, .\39 u\24\28small\29 {
			width: 75%;
			clear: none;
			margin-left: 0;
		}

		.\38 u\28small\29, .\38 u\24\28small\29 {
			width: 66.6666666667%;
			clear: none;
			margin-left: 0;
		}

		.\37 u\28small\29, .\37 u\24\28small\29 {
			width: 58.3333333333%;
			clear: none;
			margin-left: 0;
		}

		.\36 u\28small\29, .\36 u\24\28small\29 {
			width: 50%;
			clear: none;
			margin-left: 0;
		}

		.\35 u\28small\29, .\35 u\24\28small\29 {
			width: 41.6666666667%;
			clear: none;
			margin-left: 0;
		}

		.\34 u\28small\29, .\34 u\24\28small\29 {
			width: 33.3333333333%;
			clear: none;
			margin-left: 0;
		}

		.\33 u\28small\29, .\33 u\24\28small\29 {
			width: 25%;
			clear: none;
			margin-left: 0;
		}

		.\32 u\28small\29, .\32 u\24\28small\29 {
			width: 16.6666666667%;
			clear: none;
			margin-left: 0;
		}

		.\31 u\28small\29, .\31 u\24\28small\29 {
			width: 8.3333333333%;
			clear: none;
			margin-left: 0;
		}

		.\31 2u\24\28small\29 + *,
		.\31 1u\24\28small\29 + *,
		.\31 0u\24\28small\29 + *,
		.\39 u\24\28small\29 + *,
		.\38 u\24\28small\29 + *,
		.\37 u\24\28small\29 + *,
		.\36 u\24\28small\29 + *,
		.\35 u\24\28small\29 + *,
		.\34 u\24\28small\29 + *,
		.\33 u\24\28small\29 + *,
		.\32 u\24\28small\29 + *,
		.\31 u\24\28small\29 + * {
			clear: left;
		}

		.\-11u\28small\29 {
			margin-left: 91.66667%;
		}

		.\-10u\28small\29 {
			margin-left: 83.33333%;
		}

		.\-9u\28small\29 {
			margin-left: 75%;
		}

		.\-8u\28small\29 {
			margin-left: 66.66667%;
		}

		.\-7u\28small\29 {
			margin-left: 58.33333%;
		}

		.\-6u\28small\29 {
			margin-left: 50%;
		}

		.\-5u\28small\29 {
			margin-left: 41.66667%;
		}

		.\-4u\28small\29 {
			margin-left: 33.33333%;
		}

		.\-3u\28small\29 {
			margin-left: 25%;
		}

		.\-2u\28small\29 {
			margin-left: 16.66667%;
		}

		.\-1u\28small\29 {
			margin-left: 8.33333%;
		}

	}

	@media screen and (max-width: 480px) {

		.row > * {
			padding: 0 0 0 1.25em;
		}

		.row {
			margin: 0 0 -1px -1.25em;
		}

		.row.uniform > * {
			padding: 1.25em 0 0 1.25em;
		}

		.row.uniform {
			margin: -1.25em 0 -1px -1.25em;
		}

		.row.\32 00\25 > * {
			padding: 0 0 0 2.5em;
		}

		.row.\32 00\25 {
			margin: 0 0 -1px -2.5em;
		}

		.row.uniform.\32 00\25 > * {
			padding: 2.5em 0 0 2.5em;
		}

		.row.uniform.\32 00\25 {
			margin: -2.5em 0 -1px -2.5em;
		}

		.row.\31 50\25 > * {
			padding: 0 0 0 1.875em;
		}

		.row.\31 50\25 {
			margin: 0 0 -1px -1.875em;
		}

		.row.uniform.\31 50\25 > * {
			padding: 1.875em 0 0 1.875em;
		}

		.row.uniform.\31 50\25 {
			margin: -1.875em 0 -1px -1.875em;
		}

		.row.\35 0\25 > * {
			padding: 0 0 0 0.625em;
		}

		.row.\35 0\25 {
			margin: 0 0 -1px -0.625em;
		}

		.row.uniform.\35 0\25 > * {
			padding: 0.625em 0 0 0.625em;
		}

		.row.uniform.\35 0\25 {
			margin: -0.625em 0 -1px -0.625em;
		}

		.row.\32 5\25 > * {
			padding: 0 0 0 0.3125em;
		}

		.row.\32 5\25 {
			margin: 0 0 -1px -0.3125em;
		}

		.row.uniform.\32 5\25 > * {
			padding: 0.3125em 0 0 0.3125em;
		}

		.row.uniform.\32 5\25 {
			margin: -0.3125em 0 -1px -0.3125em;
		}

		.\31 2u\28xsmall\29, .\31 2u\24\28xsmall\29 {
			width: 100%;
			clear: none;
			margin-left: 0;
		}

		.\31 1u\28xsmall\29, .\31 1u\24\28xsmall\29 {
			width: 91.6666666667%;
			clear: none;
			margin-left: 0;
		}

		.\31 0u\28xsmall\29, .\31 0u\24\28xsmall\29 {
			width: 83.3333333333%;
			clear: none;
			margin-left: 0;
		}

		.\39 u\28xsmall\29, .\39 u\24\28xsmall\29 {
			width: 75%;
			clear: none;
			margin-left: 0;
		}

		.\38 u\28xsmall\29, .\38 u\24\28xsmall\29 {
			width: 66.6666666667%;
			clear: none;
			margin-left: 0;
		}

		.\37 u\28xsmall\29, .\37 u\24\28xsmall\29 {
			width: 58.3333333333%;
			clear: none;
			margin-left: 0;
		}

		.\36 u\28xsmall\29, .\36 u\24\28xsmall\29 {
			width: 50%;
			clear: none;
			margin-left: 0;
		}

		.\35 u\28xsmall\29, .\35 u\24\28xsmall\29 {
			width: 41.6666666667%;
			clear: none;
			margin-left: 0;
		}

		.\34 u\28xsmall\29, .\34 u\24\28xsmall\29 {
			width: 33.3333333333%;
			clear: none;
			margin-left: 0;
		}

		.\33 u\28xsmall\29, .\33 u\24\28xsmall\29 {
			width: 25%;
			clear: none;
			margin-left: 0;
		}

		.\32 u\28xsmall\29, .\32 u\24\28xsmall\29 {
			width: 16.6666666667%;
			clear: none;
			margin-left: 0;
		}

		.\31 u\28xsmall\29, .\31 u\24\28xsmall\29 {
			width: 8.3333333333%;
			clear: none;
			margin-left: 0;
		}

		.\31 2u\24\28xsmall\29 + *,
		.\31 1u\24\28xsmall\29 + *,
		.\31 0u\24\28xsmall\29 + *,
		.\39 u\24\28xsmall\29 + *,
		.\38 u\24\28xsmall\29 + *,
		.\37 u\24\28xsmall\29 + *,
		.\36 u\24\28xsmall\29 + *,
		.\35 u\24\28xsmall\29 + *,
		.\34 u\24\28xsmall\29 + *,
		.\33 u\24\28xsmall\29 + *,
		.\32 u\24\28xsmall\29 + *,
		.\31 u\24\28xsmall\29 + * {
			clear: left;
		}

		.\-11u\28xsmall\29 {
			margin-left: 91.66667%;
		}

		.\-10u\28xsmall\29 {
			margin-left: 83.33333%;
		}

		.\-9u\28xsmall\29 {
			margin-left: 75%;
		}

		.\-8u\28xsmall\29 {
			margin-left: 66.66667%;
		}

		.\-7u\28xsmall\29 {
			margin-left: 58.33333%;
		}

		.\-6u\28xsmall\29 {
			margin-left: 50%;
		}

		.\-5u\28xsmall\29 {
			margin-left: 41.66667%;
		}

		.\-4u\28xsmall\29 {
			margin-left: 33.33333%;
		}

		.\-3u\28xsmall\29 {
			margin-left: 25%;
		}

		.\-2u\28xsmall\29 {
			margin-left: 16.66667%;
		}

		.\-1u\28xsmall\29 {
			margin-left: 8.33333%;
		}

	}

/* Basic */

	@-ms-viewport {
		width: device-width;
	}

	body {
		-ms-overflow-style: scrollbar;
	}

	@media screen and (max-width: 480px) {

		html, body {
			min-width: 320px;
		}

	}

	body {
		background: #fff;
	}

		body.is-loading *, body.is-loading *:before, body.is-loading *:after {
			-moz-animation: none !important;
			-webkit-animation: none !important;
			-ms-animation: none !important;
			animation: none !important;
			-moz-transition: none !important;
			-webkit-transition: none !important;
			-ms-transition: none !important;
			transition: none !important;
		}

	.inner {
		margin: 0 auto;
		max-width: 65em;
	}

		@media screen and (max-width: 1280px) {

			.inner {
				max-width: 90%;
			}

		}

		@media screen and (max-width: 980px) {

			.inner {
				max-width: 70%;
			}

		}

		@media screen and (max-width: 736px) {

			.inner {
				max-width: 85%;
			}

		}

/* Type */

	body, input, select, textarea {
		color: #767d85;
		font-family: "Open Sans", Arial, Helvetica, sans-serif;
		font-size: 13pt;
		font-weight: 300;
		line-height: 1.65;
	}

		@media screen and (max-width: 1680px) {

			body, input, select, textarea {
				font-size: 11pt;
			}

		}

		@media screen and (max-width: 1280px) {

			body, input, select, textarea {
				font-size: 11pt;
			}

		}

		@media screen and (max-width: 980px) {

			body, input, select, textarea {
				font-size: 12pt;
			}

		}

		@media screen and (max-width: 736px) {

			body, input, select, textarea {
				font-size: 12pt;
			}

		}

		@media screen and (max-width: 480px) {

			body, input, select, textarea {
				font-size: 12pt;
			}

		}

	a {
		color: #25a2c3;
		text-decoration: underline;
	}

		a:hover {
			text-decoration: none;
		}

	strong, b {
		color: #727a82;
		font-weight: 700;
	}

	em, i {
		font-style: italic;
	}

	p {
		margin: 0 0 2em 0;
	}

	h1, h2, h3, h4, h5, h6 {
		color: #727a82;
		font-weight: 700;
		font-family: "Montserrat", sans-serif;
		line-height: 1.5;
		margin: 0 0 1em 0;
	}

		h1 a, h2 a, h3 a, h4 a, h5 a, h6 a {
			color: inherit;
			text-decoration: none;
		}

	h1 {
		font-size: 2em;
		line-height: 1.3;
	}

	h2 {
		font-size: 1.75em;
	}

	h3 {
		font-size: 1.25em;
	}

	h4 {
		font-size: 1em;
	}

	h5 {
		font-size: 0.9em;
	}

	h6 {
		font-size: 0.7em;
	}

	sub {
		font-size: 0.8em;
		position: relative;
		top: 0.5em;
	}

	sup {
		font-size: 0.8em;
		position: relative;
		top: -0.5em;
	}

	blockquote {
		font-style: italic;
		margin: 0 0 2em 0;
	}

	cite {
		display: block;
	}

		cite.author {
			font-weight: 400;
		}

		cite.company {
			font-size: .8em;
		}

	figure {
		margin: 0 0 2em 0;
	}

	code {
		background: rgba(144, 144, 144, 0.075);
		border-radius: 4px;
		border: solid 1px #dee1e3;
		font-family: "Courier New", monospace;
		font-size: 0.9em;
		margin: 0 0.25em;
		padding: 0.25em 0.65em;
	}

	pre {
		-webkit-overflow-scrolling: touch;
		font-family: "Courier New", monospace;
		font-size: 0.9em;
		margin: 0 0 2em 0;
	}

		pre code {
			display: block;
			line-height: 1.75;
			padding: 1em 1.5em;
			overflow-x: auto;
		}

	hr {
		border: 0;
		border-bottom: solid 1px #dee1e3;
		margin: 2em 0;
	}

		hr.major {
			margin: 3em 0;
		}

	.align-left {
		text-align: left;
	}

	.align-center {
		text-align: center;
	}

	.align-right {
		text-align: right;
	}

/* Section/Article */

	section.special, article.special {
		text-align: center;
	}

	header p {   
     
		position: relative;
		margin: 0 0 1.5em 0;
	}

	header h1 + p {
		font-size: 1.25em;
		margin-top: -1em;
	}

	header h2 + p {
		font-size: 1.25em;
		margin-top: -1em;
	}

	header h3 + p {
		font-size: 1.1em;
		margin-top: -0.8em;
	}

	header h4 + p,
	header h5 + p,
	header h6 + p {
		font-size: 0.9em;
		margin-top: -0.6em;
	}

/* Form */

	form {
		margin: 0 0 2em 0;
	}

	label {
		color: #727a82;
		display: block;
		font-size: 0.9em;
		font-weight: 700;
		margin: 0 0 1em 0;
	}

	input[type="text"],
	input[type="password"],
	input[type="email"],
	input[type="tel"],
	select,
	textarea {
		-moz-appearance: none;
		-webkit-appearance: none;
		-ms-appearance: none;
		appearance: none;
		background: rgba(144, 144, 144, 0.075);
		border-radius: 4px;
		border: none;
		border: solid 1px #dee1e3;
		color: inherit;
		display: block;
		outline: 0;
		padding: 0 1em;
		text-decoration: none;
		width: 100%;
	}

		input[type="text"]:invalid,
		input[type="password"]:invalid,
		input[type="email"]:invalid,
		input[type="tel"]:invalid,
		select:invalid,
		textarea:invalid {
			box-shadow: none;
		}

		input[type="text"]:focus,
		input[type="password"]:focus,
		input[type="email"]:focus,
		input[type="tel"]:focus,
		select:focus,
		textarea:focus {
			border-color: #25a2c3;
			box-shadow: 0 0 0 1px #25a2c3;
		}

	.select-wrapper {
		text-decoration: none;
		display: block;
		position: relative;
	}

		.select-wrapper:before {
			content: "";
			-moz-osx-font-smoothing: grayscale;
			-webkit-font-smoothing: antialiased;
			font-family: FontAwesome;
			font-style: normal;
			font-weight: normal;
			text-transform: none !important;
		}

		.select-wrapper:before {
			color: #dee1e3;
			display: block;
			height: 2.75em;
			line-height: 2.75em;
			pointer-events: none;
			position: absolute;
			right: 0;
			text-align: center;
			top: 0;
			width: 2.75em;
		}

		.select-wrapper select::-ms-expand {
			display: none;
		}

	input[type="text"],
	input[type="password"],
	input[type="email"],
	select {
		height: 3.5em;
		line-height: 3.5em;
	}

	textarea {
		padding: 0.75em 1em;
	}

	input[type="checkbox"],
	input[type="radio"] {
		-moz-appearance: none;
		-webkit-appearance: none;
		-ms-appearance: none;
		appearance: none;
		display: block;
		float: left;
		margin-right: -2em;
		opacity: 0;
		width: 1em;
		z-index: -1;
	}

		input[type="checkbox"] + label,
		input[type="radio"] + label {
			text-decoration: none;
			color: #767d85;
			cursor: pointer;
			display: inline-block;
			font-size: 1em;
			font-weight: 300;
			padding-left: 2.4em;
			padding-right: 0.75em;
			position: relative;
		}

			input[type="checkbox"] + label:before,
			input[type="radio"] + label:before {
				-moz-osx-font-smoothing: grayscale;
				-webkit-font-smoothing: antialiased;
				font-family: FontAwesome;
				font-style: normal;
				font-weight: normal;
				text-transform: none !important;
			}

			input[type="checkbox"] + label:before,
			input[type="radio"] + label:before {
				background: rgba(144, 144, 144, 0.075);
				border-radius: 4px;
				border: solid 1px #dee1e3;
				content: '';
				display: inline-block;
				height: 1.65em;
				left: 0;
				line-height: 1.58125em;
				position: absolute;
				text-align: center;
				top: 0;
				width: 1.65em;
			}

		input[type="checkbox"]:checked + label:before,
		input[type="radio"]:checked + label:before {
			background: #f6755e;
			border-color: #f6755e;
			color: #ffffff;
			content: '\f00c';
		}

		input[type="checkbox"]:focus + label:before,
		input[type="radio"]:focus + label:before {
			border-color: #25a2c3;
			box-shadow: 0 0 0 1px #25a2c3;
		}

	input[type="checkbox"] + label:before {
		border-radius: 4px;
	}

	input[type="radio"] + label:before {
		border-radius: 100%;
	}

	::-webkit-input-placeholder {
		color: #bbb !important;
		opacity: 1.0;
	}

	:-moz-placeholder {
		color: #bbb !important;
		opacity: 1.0;
	}

	::-moz-placeholder {
		color: #bbb !important;
		opacity: 1.0;
	}

	:-ms-input-placeholder {
		color: #bbb !important;
		opacity: 1.0;
	}

	.formerize-placeholder {
		color: #bbb !important;
		opacity: 1.0;
	}

/* Box */

	.box {
		border-radius: 4px;
		border: solid 1px #dee1e3;
		margin-bottom: 2em;
		overflow: hidden;
	}

		.box > :last-child,
		.box > :last-child > :last-child,
		.box > :last-child > :last-child > :last-child {
			margin-bottom: 0;
		}

		.box .image.fit {
			margin: 0;
		}

		.box .content {
			padding: 1.5em;
		}

		.box.alt {
			border: 0;
			border-radius: 0;
			padding: 0;
		}

/* Icon */

	.icon {
		text-decoration: none;
		border-bottom: none;
		position: relative;
	}

		.icon:before {
			-moz-osx-font-smoothing: grayscale;
			-webkit-font-smoothing: antialiased;
			font-family: FontAwesome;
			font-style: normal;
			font-weight: normal;
			text-transform: none !important;
		}

		.icon > .label {
			display: none;
		}

/* Image */

	.image {
		border: 0;
		display: inline-block;
		position: relative;
	}

		.image img {
			display: block;
		}

		.image.left, .image.right {
			max-width: 40%;
		}

			.image.left img, .image.right img {
				width: 100%;
			}

		.image.left {
			float: left;
			padding: 0 1.5em 1em 0;
			top: 0.25em;
		}

		.image.right {
			float: right;
			padding: 0 0 1em 1.5em;
			top: 0.25em;
		}

		.image.fit {
			display: block;
			margin: 0 0 2em 0;
			width: 100%;
		}

			.image.fit img {
				width: 100%;
			}

		.image.round img {
			border-radius: 100%;
		}

		.image.main {
			display: block;
			margin: 0 0 3em 0;
			width: 100%;
		}

			.image.main img {
				width: 100%;
			}

/* List */

	ol {
		list-style: decimal;
		margin: 0 0 2em 0;
		padding-left: 1.25em;
	}

		ol li {
			padding-left: 0.25em;
		}

	ul {
		list-style: disc;
		margin: 0 0 2em 0;
		padding-left: 1em;
	}

		ul li {
			padding-left: 0.5em;
		}

		ul.alt {
			list-style: none;
			padding-left: 0;
		}

			ul.alt li {
				border-top: solid 1px #dee1e3;
				padding: 0.5em 0;
			}

				ul.alt li:first-child {
					border-top: 0;
					padding-top: 0;
				}

		ul.icons {
			cursor: default;
			list-style: none;
			padding-left: 0;
		}

			ul.icons li {
				display: inline-block;
				padding: 0 1em 0 0;
			}

				ul.icons li:last-child {
					padding-right: 0;
				}

				ul.icons li .icon:before {
					font-size: 2em;
				}

		ul.actions {
			cursor: default;
			list-style: none;
			padding-left: 0;
		}

			ul.actions li {
				display: inline-block;
				padding: 0 1em 0 0;
				vertical-align: middle;
			}

				ul.actions li:last-child {
					padding-right: 0;
				}

			ul.actions.small li {
				padding: 0 0.5em 0 0;
			}

			ul.actions.vertical li {
				display: block;
				padding: 1em 0 0 0;
			}

				ul.actions.vertical li:first-child {
					padding-top: 0;
				}

				ul.actions.vertical li > * {
					margin-bottom: 0;
				}

			ul.actions.vertical.small li {
				padding: 0.5em 0 0 0;
			}

				ul.actions.vertical.small li:first-child {
					padding-top: 0;
				}

			ul.actions.fit {
				display: table;
				margin-left: -1em;
				padding: 0;
				table-layout: fixed;
				width: calc(100% + 1em);
			}

				ul.actions.fit li {
					display: table-cell;
					padding: 0 0 0 1em;
				}

					ul.actions.fit li > * {
						margin-bottom: 0;
					}

				ul.actions.fit.small {
					margin-left: -0.5em;
					width: calc(100% + 0.5em);
				}

					ul.actions.fit.small li {
						padding: 0 0 0 0.5em;
					}

			@media screen and (max-width: 480px) {

				ul.actions {
					margin: 0 0 2em 0;
				}

					ul.actions li {
						padding: 1em 0 0 0;
						display: block;
						text-align: center;
						width: 100%;
					}

						ul.actions li:first-child {
							padding-top: 0;
						}

						ul.actions li > * {
							width: 100%;
							margin: 0 !important;
						}

							ul.actions li > *.icon:before {
								margin-left: -2em;
							}

					ul.actions.small li {
						padding: 0.5em 0 0 0;
					}

						ul.actions.small li:first-child {
							padding-top: 0;
						}

			}

	dl {
		margin: 0 0 2em 0;
	}

		dl dt {
			display: block;
			font-weight: 700;
			margin: 0 0 1em 0;
		}

		dl dd {
			margin-left: 2em;
		}

/* Table */

	.table-wrapper {
		-webkit-overflow-scrolling: touch;
		overflow-x: auto;
	}

	table {
		margin: 0 0 2em 0;
		width: 100%;
	}

		table tbody tr {
			border: solid 1px #dee1e3;
			border-left: 0;
			border-right: 0;
		}

			table tbody tr:nth-child(2n + 1) {
				background-color: rgba(144, 144, 144, 0.075);
			}

		table td {
			padding: 0.75em 0.75em;
		}

		table th {
			color: #727a82;
			font-size: 0.9em;
			font-weight: 700;
			padding: 0 0.75em 0.75em 0.75em;
			text-align: left;
		}

		table thead {
			border-bottom: solid 2px #dee1e3;
		}

		table tfoot {
			border-top: solid 2px #dee1e3;
		}

		table.alt {
			border-collapse: separate;
		}

			table.alt tbody tr td {
				border: solid 1px #dee1e3;
				border-left-width: 0;
				border-top-width: 0;
			}

				table.alt tbody tr td:first-child {
					border-left-width: 1px;
				}

			table.alt tbody tr:first-child td {
				border-top-width: 1px;
			}

			table.alt thead {
				border-bottom: 0;
			}

			table.alt tfoot {
				border-top: 0;
			}
		startcounter {
		  list-style-type: none;
		  counter-reset: css-counter 0; /* initializes counter to 0; use -1 for zero-based numbering */
		}
		
		startcounter number {
		  counter-increment: css-counter 1; /* Increase the counter by 1. */
		}
		
		startcounter number:before {
		  content: counter(css-counter) ". "; /* Apply counter before children's content. */
		}
/* Button */

	input[type="submit"],
	input[type="reset"],
	input[type="button"],
	button,
	.button {
		-moz-appearance: none;
		-webkit-appearance: none;
		-ms-appearance: none;
		appearance: none;
		-moz-transition: background-color 0.2s ease-in-out, color 0.2s ease-in-out;
		-webkit-transition: background-color 0.2s ease-in-out, color 0.2s ease-in-out;
		-ms-transition: background-color 0.2s ease-in-out, color 0.2s ease-in-out;
		transition: background-color 0.2s ease-in-out, color 0.2s ease-in-out;
		background-color: #f6755e;
		border-radius: 2px;
		border: 0;
		color: #ffffff;
		cursor: pointer;
		display: inline-block;
		font-family: "Montserrat", sans-serif;
		height: 3.5em;
		line-height: 3.5em;
		padding: 0 0.5em;
		text-align: center;
		text-decoration: none;
		white-space: nowrap;
	}

		input[type="submit"]:hover,
		input[type="reset"]:hover,
		input[type="button"]:hover,
		button:hover,
		.button:hover {
			background-color: #f78a76;
		}

		input[type="submit"]:active,
		input[type="reset"]:active,
		input[type="button"]:active,
		button:active,
		.button:active {
			background-color: #f56046;
		}

		input[type="submit"].icon,
		input[type="reset"].icon,
		input[type="button"].icon,
		button.icon,
		.button.icon {
			padding-left: 1.35em;
		}

			input[type="submit"].icon:before,
			input[type="reset"].icon:before,
			input[type="button"].icon:before,
			button.icon:before,
			.button.icon:before {
				margin-right: 0.5em;
			}

		input[type="submit"].fit,
		input[type="reset"].fit,
		input[type="button"].fit,
		button.fit,
		.button.fit {
			display: block;
			margin: 0 0 1em 0;
			width: 100%;
		}

		input[type="submit"].small,
		input[type="reset"].small,
		input[type="button"].small,
		button.small,
		.button.small {
			font-size: 0.8em;
		}

		input[type="submit"].big,
		input[type="reset"].big,
		input[type="button"].big,
		button.big,
		.button.big {
			font-size: 1.35em;
		}

		input[type="submit"].alt,
		input[type="reset"].alt,
		input[type="button"].alt,
		button.alt,
		.button.alt {
			background-color: transparent;
			box-shadow: inset 0 0 0 0.1px #dee1e3;
			color: #727a82 !important;
		}

			input[type="submit"].alt:active,
			input[type="reset"].alt:active,
			input[type="button"].alt:active,
			button.alt:active,
			.button.alt:active {
				background-color: rgba(144, 144, 144, 0.2);
			}

			input[type="submit"].alt.icon:before,
			input[type="reset"].alt.icon:before,
			input[type="button"].alt.icon:before,
			button.alt.icon:before,
			.button.alt.icon:before {
				color: #bbb;
			}

		input[type="submit"].special,
		input[type="reset"].special,
		input[type="button"].special,
		button.special,
		.button.special {
			background-color: #25a2c3;
			color: #ffffff !important;
		}

			input[type="submit"].special:hover,
			input[type="reset"].special:hover,
			input[type="button"].special:hover,
			button.special:hover,
			.button.special:hover {
				background-color: #2bb3d7;
			}

			input[type="submit"].special:active,
			input[type="reset"].special:active,
			input[type="button"].special:active,
			button.special:active,
			.button.special:active {
				background-color: #2190ae;
			}

		input[type="submit"].disabled, input[type="submit"]:disabled,
		input[type="reset"].disabled,
		input[type="reset"]:disabled,
		input[type="button"].disabled,
		input[type="button"]:disabled,
		button.disabled,
		button:disabled,
		.button.disabled,
		.button:disabled {
			background-color: #767d85 !important;
			box-shadow: inset 0 -0.15em 0 0 rgba(0, 0, 0, 0.15);
			color: #fff !important;
			cursor: default;
			opacity: 0.25;
		}

		@media screen and (max-width: 480px) {

			input[type="submit"],
			input[type="reset"],
			input[type="button"],
			button,
			.button {
				padding: 0;
			}

		}

/* Flex */

	.flex {
		display: -ms-flexbox;
		-ms-flex-wrap: nowrap;
		-ms-flex-pack: justify;
		-ms-flex-align: stretch;
		display: -moz-flex;
		display: -webkit-flex;
		display: -ms-flex;
		display: flex;
		-moz-flex-wrap: nowrap;
		-webkit-flex-wrap: nowrap;
		-ms-flex-wrap: nowrap;
		flex-wrap: nowrap;
		-moz-justify-content: space-between;
		-webkit-justify-content: space-between;
		-ms-justify-content: space-between;
		justify-content: space-between;
		-moz-align-items: stretch;
		-webkit-align-items: stretch;
		-ms-align-items: stretch;
		align-items: stretch;
	}

		.flex.flex-3 .flex-item {
			-ms-flex: 0 1 auto;
			-ms-flex-preferred-size: 30%;
			-moz-flex-basis: 30%;
			-webkit-flex-basis: 30%;
			-ms-flex-basis: 30%;
			flex-basis: 30%;
		}

			.flex.flex-3 .flex-item.left {
				text-align: right;
			}

		@media screen and (max-width: 980px) {

			.flex {
				-ms-flex-wrap: wrap;
				-moz-flex-wrap: wrap;
				-webkit-flex-wrap: wrap;
				-ms-flex-wrap: wrap;
				flex-wrap: wrap;
			}

				.flex.flex-3 .flex-item {
					-ms-flex-preferred-size: 100%;
					-moz-flex-basis: 100%;
					-webkit-flex-basis: 100%;
					-ms-flex-basis: 100%;
					flex-basis: 100%;
				}

					.flex.flex-3 .flex-item.left {
						text-align: right;
					}

		}

/* Wrapper */

	.wrapper {
		padding: 6em 0 4em 0;
	}

		.wrapper h1, .wrapper h2, .wrapper h3, .wrapper h4, .wrapper h5 {
			color: #25a2c3;
		}

		.wrapper.style1 {
			background: #f6755e;
			color: #fcdcd6;
		}

			.wrapper.style1 h1, .wrapper.style1 h2, .wrapper.style1 h3, .wrapper.style1 h4, .wrapper.style1 h5 {
				color: #fff;
			}

			.wrapper.style1 cite.author {
				color: #fff;
			}

		@media screen and (max-width: 980px) {

			.wrapper {
				padding: 3em 0 1em 0;
			}

		}

		@media screen and (max-width: 480px) {

			.wrapper {
				padding: 2em 0 0.1em 0;
			}

		}

/* Header */

	body {
		padding-top: 6em;
	}

	#header {
		-moz-align-items: center;
		-webkit-align-items: center;
		-ms-align-items: center;
		align-items: center;
		background: #e7e7e7;
        color: black;
		cursor: default;
		height: 6em;
		left: 0;
		line-height: 6em;
		position: fixed;
		top: 0;
		width: 100%;
		z-index: 10001;
		box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.075);
		text-align: center;
	}

		#header .logo {
			color: #f6755e;
			font-family: "Pacifico", cursive;
			font-size: 2.5em;
			letter-spacing: 2px;
			margin-top: -5px;
			text-decoration: none;
			display: inline-block;
		}

		#header nav {
			position: absolute;
			top: 0;
			height: inherit;
			line-height: inherit;
		}

			#header nav.left {
				left: 2em;
			}

			#header nav.right {
				right: 2em;
			}

			#header nav .button {
				padding: 0 2em;
				height: 3.25em;
				line-height: 3.25em;
			}

			#header nav a {
				text-decoration: none;
				display: inline-block;
			}

				#header nav a[href="#menu"] {
					text-decoration: none;
					-webkit-tap-highlight-color: transparent;
					font-size: 2em;
					color: #dee1e3;
					z-index: 10005;
				}

					#header nav a[href="#menu"]:before {
						content: "";
						-moz-osx-font-smoothing: grayscale;
						-webkit-font-smoothing: antialiased;
						font-family: FontAwesome;
						font-style: normal;
						font-weight: normal;
						text-transform: none !important;
					}

					#header nav a[href="#menu"] span {
						display: none;
					}

					#header nav a[href="#menu"]:before {
						margin: 0 0.5em 0 0;
					}

	@media screen and (max-width: 980px) {

		body {
			padding-top: 44px;
		}

		#header {
			height: 44px;
			line-height: 44px;
		}

			#header .logo {
				font-size: 1.25em;
				text-align: center;
			}

			#header nav a[href="#menu"] {
				font-size: 1.5em;
			}

			#header nav.left {
				left: 1em;
			}

			#header nav.right {
				display: none;
			}

	}

	@media screen and (max-width: 480px) {

		#header {
			min-width: 320px;
		}

	}

/* Menu */
	black {
	color: black;
	}
	#menu {
		-moz-transform: translateX(-20em);
		-webkit-transform: translateX(-20em);
		-ms-transform: translateX(-20em);
		transform: translateX(-20em);
		-moz-transition: -moz-transform 0.5s ease, visibility 0.5s;
		-webkit-transition: -webkit-transform 0.5s ease, visibility 0.5s;
		-ms-transition: -ms-transform 0.5s ease, visibility 0.5s;
		transition: transform 0.5s ease, visibility 0.5s;
		-webkit-overflow-scrolling: touch;
		background: #25a2c3;
		color: #ffffff;
		height: 100%;
		max-width: 80%;
		overflow-y: auto;
		padding: 3em 2em;
		position: fixed;
		left: 0;
		top: 0;
		visibility: hidden;
		width: 20em;
		z-index: 10002;
	}

		#menu > ul {
			margin: 0 0 1em 0;
		}

			#menu > ul.links {
				list-style: none;
				padding: 0;
			}

				#menu > ul.links > li {
					padding: 0;
				}

					#menu > ul.links > li > a:not(.button) {
						border: 0;
						border-top: solid 1px rgba(255, 255, 255, 0.25);
						color: inherit;
						display: block;
						line-height: 3.5em;
						text-decoration: none;
					}

					#menu > ul.links > li > .button {
						display: block;
						margin: 0.5em 0 0 0;
					}

					#menu > ul.links > li:first-child > a:not(.button) {
						border-top: 0 !important;
					}

			#menu > ul.actions {
				display: none;
			}

		#menu .close {
			text-decoration: none;
			-moz-transition: color 0.2s ease-in-out;
			-webkit-transition: color 0.2s ease-in-out;
			-ms-transition: color 0.2s ease-in-out;
			transition: color 0.2s ease-in-out;
			-webkit-tap-highlight-color: transparent;
			border: 0;
			color: #a7d9e7;
			cursor: pointer;
			display: block;
			height: 3.25em;
			line-height: 3.25em;
			padding-right: 1.25em;
			position: absolute;
			right: 0;
			text-align: right;
			top: 0;
			vertical-align: middle;
			width: 7em;
		}

			#menu .close:before {
				content: "";
				-moz-osx-font-smoothing: grayscale;
				-webkit-font-smoothing: antialiased;
				font-family: FontAwesome;
				font-style: normal;
				font-weight: normal;
				text-transform: none !important;
			}

			#menu .close:before {
				font-size: 1.25em;
			}

			#menu .close:hover {
				color: #ffffff;
			}

			@media screen and (max-width: 736px) {

				#menu .close {
					height: 4em;
					line-height: 4em;
				}

			}

		#menu.visible {
			-moz-transform: translateX(0);
			-webkit-transform: translateX(0);
			-ms-transform: translateX(0);
			transform: translateX(0);
			visibility: visible;
		}

		@media screen and (max-width: 980px) {

			#menu ul.actions {
				display: block;
			}

		}

		@media screen and (max-width: 736px) {

			#menu {
				padding: 2.5em 1.75em;
			}

		}

/* Banner */

	#banner {
		padding: 14em 0 12em 0;
		background-image: url(../../images/banner.jpg);
		background-size: cover;
		background-position: center top;
		background-repeat: no-repeat;
		text-align: center;
	}

		#banner .content {
			-moz-transition: opacity 1s ease-in-out, -moz-transform 0.75s ease-in-out;
			-webkit-transition: opacity 1s ease-in-out, -webkit-transform 0.75s ease-in-out;
			-ms-transition: opacity 1s ease-in-out, -ms-transform 0.75s ease-in-out;
			transition: opacity 1s ease-in-out, transform 0.75s ease-in-out;
			opacity: 1;
		}

		#banner h1 {
			font-size: 3em;
			color: #25a2c3;
			line-height: 1em;
			margin: 0 0 0.5em 0;
			padding: 0;
		}

		#banner p {
			font-size: 1.25em;
			margin-bottom: 1.75em;
		}

		@media screen and (max-width: 1280px) {

			#banner {
				padding: 12em 0 10em 0;
			}

		}

		@media screen and (max-width: 980px) {

			#banner {
				padding: 8em 6em 6em 6em;
			}

				#banner br {
					display: none;
				}

				#banner h1 {
					font-size: 2.25em;
				}

		}

		@media screen and (max-width: 736px) {

			#banner {
				padding: 6em 4em 4em 4em;
			}

		}

		@media screen and (max-width: 480px) {

			#banner {
				padding: 4em 2em 2em 2em;
			}

				#banner h1 {
					font-size: 2em;
				}

				#banner p {
					font-size: 1em;
				}

				#banner .button {
					font-size: .9em;
				}

		}

		body.is-loading #banner .content {
			opacity: 0;
			-moz-transform: translateY(1em);
			-webkit-transform: translateY(1em);
			-ms-transform: translateY(1em);
			transform: translateY(1em);
		}

/* Main */

	#one .inner {
		margin-bottom: 2em;
	}

	#one .flex-item {
		display: -ms-flexbox;
		-ms-flex-wrap: wrap;
		-ms-flex-pack: justify;
		display: -moz-flex;
		display: -webkit-flex;
		display: -ms-flex;
		display: flex;
		-moz-flex-wrap: wrap;
		-webkit-flex-wrap: wrap;
		-ms-flex-wrap: wrap;
		flex-wrap: wrap;
		-moz-justify-content: space-between;
		-webkit-justify-content: space-between;
		-ms-justify-content: space-between;
		justify-content: space-between;
		-moz-align-items: stretch;
		-webkit-align-items: stretch;
		-ms-align-items: stretch;
		align-items: stretch;
	}

		#one .flex-item.left div:first-child, #one .flex-item.right div:first-child {
			padding-top: 1em;
		}

		#one .flex-item.left div:last-child, #one .flex-item.right div:last-child {
			-moz-align-self: -moz-flex-end;
			-webkit-align-self: -webkit-flex-end;
			-ms-align-self: -ms-flex-end;
			align-self: flex-end;
		}

		#one .flex-item.left div p, #one .flex-item.right div p {
			margin-bottom: 1em;
		}

		@media screen and (max-width: 1280px) {

			#one .flex-item.left div:first-child, #one .flex-item.right div:first-child {
				padding-top: 0;
			}

			#one .flex-item.left div p, #one .flex-item.right div p {
				margin-bottom: 0;
			}

		}

		@media screen and (max-width: 980px) {

			#one .flex-item {
				-moz-flex-direction: column;
				-webkit-flex-direction: column;
				-ms-flex-direction: column;
				flex-direction: column;
				text-align: center;
			}

				#one .flex-item.left br, #one .flex-item.right br {
					display: none;
				}

				#one .flex-item.left div:first-child, #one .flex-item.right div:first-child {
					padding-top: 0;
				}

				#one .flex-item.left div:last-child, #one .flex-item.right div:last-child {
					-moz-align-self: center;
					-webkit-align-self: center;
					-ms-align-self: center;
					align-self: center;
				}

				#one .flex-item.left div p, #one .flex-item.right div p {
					margin-bottom: 2em;
				}

		}

	#one .image.fit {
		margin: 0;
	}

		@media screen and (max-width: 980px) {

			#one .image.fit {
				margin: 0 auto 2em auto;
				max-width: 60%;
			}

		}

		@media screen and (max-width: 480px) {

			#one .image.fit {
				margin: 0 auto 2em auto;
				max-width: 90%;
			}

		}

	@media screen and (max-width: 980px) {

		#two blockquote br {
			display: none;
		}

	}

	@media screen and (max-width: 980px) {

		#three {
			text-align: center;
		}

	}

/* Footer */

	#footer {
		padding: 6em 0 4em 0;
		background: #25a2c3;
		text-align: center;
		color: #c8e7f0;
	}

		#footer h2 {
			color: #fff;
		}

		#footer .icon {
			color: #f6755e;
		}

		#footer a {
			color: #c8e7f0;
			text-decoration: none;
		}

		#footer ul li {
			padding: 0 2em;
		}

		#footer .copyright {
			display: inline-block;
			color: #a7d9e7;
			font-size: 0.75em;
			margin: 0 0 2em 0;
			padding: 0;
			text-align: center;
			border-top: 1px solid rgba(255, 255, 255, 0.25);
			padding: 2em 10em;
		}

		@media screen and (max-width: 980px) {

			#footer {
				padding: 3em 0 1em 0;
			}

				#footer ul li {
					display: block;
					padding: .25em 0;
				}

		}

		@media screen and (max-width: 736px) {

			#footer .copyright {
				padding: 2em 5em;
			}

		}

		@media screen and (max-width: 480px) {

			#footer {
				padding: 2em 0 0.1em 0;
			}

				#footer ul li {
					font-size: .9em;
				}

					#footer ul li .icon:before {
						margin-left: -1em;
					}

				#footer .copyright {
					padding: 2em 0;
				}

		}
  </style>
  <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta charset="utf-8" />

</head>

<body><!-- Header -->
			<header id="header">
				<a href="${pageContext.request.contextPath}/" class="logo">Merchant Manager</a>
				<nav class="right">
					<form:form action="${pageContext.request.contextPath}/showMyLoginPage" class="button alt"
			   method="POST">
	
		<input type="submit" value="Login" />
	
	</form:form>
				</nav>
			</header>
		<!-- Menu -->
			<nav id="menu">
				<ul class="links">
					<li><a href="${pageContext.request.contextPath}/showMyLoginPage">Login</a></li>
				</ul>
			</nav>

		<!-- Scripts -->
			<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.min.js"></script>
			<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.scrolly.min.js"></script>
			<script src="${pageContext.request.contextPath}/resources/assets/js/skel.min.js"></script>
			<script src="${pageContext.request.contextPath}/resources/assets/js/util.js"></script>
			<script src="${pageContext.request.contextPath}/resources/assets/js/main.js"></script>

	<c:if test="${registrationError != null}">

		<div class="alert alert-danger col-xs-offset-1 col-xs-10">
			${registrationError}
		</div>
	</c:if>
	<!-- Check for registration error -->
	<c:if test="${successMessage != null}">

		<div class="alert alert-success">
			${successMessage}
		</div>

	</c:if>


	<!-- Check for registration error -->
	<c:if test="${someerror != null}">

		<div class="alert alert-danger col-xs-offset-1 col-xs-10r">
			${someerror}
		</div>

	</c:if>

  <section id="main" class="wrapper">
    <div class="inner">
	
		<h1>Register New Company</h1>

					<!-- Registration Form -->
					<form:form action="${pageContext.request.contextPath}/register/processRegistrationForm" 
						  	   modelAttribute="crmUser"
						  	   class="form-horizontal">
						<h3>Enter Username - </h3>
						<!-- User name -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<form:errors path="userName" cssClass="error alert alert-danger" />
							
							<form:input path="userName" placeholder="username (*)" class="form-control" />
						</div>
						<br>
						<h3>Enter Password - </h3>
						<!-- Password -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							<form:errors path="password" cssClass="error alert alert-danger" />
							
							<form:password path="password" placeholder="password (*)" class="form-control" />
						</div>
						<h3> Confirm Your Password - </h3>
						<!-- Confirm Password -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							<form:errors path="matchingPassword" cssClass="error alert alert-danger" />
							<form:password path="matchingPassword" placeholder="confirm password (*)" class="form-control" />
						</div>
						<br>
						<h3>Firm Name - </h3>
						<!-- Display Name-->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<form:errors path="displayName" cssClass="error alert alert-danger" />
							<form:input path="displayName" placeholder="Your Name (*)" class="form-control" />
						</div>
						<br>
						<h3>Mobile Number - </h3>
						<!-- Email-->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<form:errors path="mobilenumber1" cssClass="error alert alert-danger" />
							<form:input path="mobilenumber1" placeholder="Mobile Number 1(*)" class="form-control" />
						</div>
						<br>
						<h3>Alternative Mobile Number - </h3>
						<!-- Email-->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<form:errors path="mobilenumber2" cssClass="error alert alert-danger" />
							<form:input path="mobilenumber2" placeholder="Mobile Number 2" class="form-control" />
						</div>
						<br>
						<h3>Email - </h3>
						<!-- Email-->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<form:errors path="email" cssClass="error alert alert-danger" />
							<form:input path="email" placeholder="Email (*)" class="form-control" />
						</div>
						<br>
						<h3>Pan Number - </h3>
						<!-- PAN -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<form:errors path="pan" cssClass="error alert alert-danger" />
							<form:input path="pan" placeholder="PAN (*)" class="form-control" />
						</div>
						<br>
						<h3>GSTIN Number - </h3>
						<!-- GSTIN-->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<form:errors path="gstin" cssClass="error alert alert-danger" />
							<form:input path="gstin" placeholder="GSTIN (*)" class="form-control" />
						</div>
						<br>
						<h3>TDS Account Number - </h3>
						<!-- TDSAccountNumber-->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<form:errors path="tdsAccountNumber" cssClass="error alert alert-danger" />
							<form:input path="tdsAccountNumber" placeholder="TDS Account Number" class="form-control" />
						</div>
						<br>
						<h3>Address Line 1 -</h3>
						<!-- Address Line 1-->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<form:errors path="addressLine1" cssClass="error alert alert-danger" />
							<form:input path="addressLine1" placeholder="Address Line 1 (*)" class="form-control" />
						</div>
						<br>
						<h3>Address Line 2 - </h3>
						<!-- Address Line 2-->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<form:errors path="addressLine2" cssClass="error alert alert-danger" />
							<form:input path="addressLine2" placeholder="Address Line 2" class="form-control" />
						</div>
						<br>
						<h3>City - </h3>
						<!-- City-->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<form:errors path="city" cssClass="error alert alert-danger" />
							<form:input path="city" placeholder="City (*)" class="form-control" />
						</div>
						<br>
						<h3>Pincode - </h3>
						<!-- PINCODE-->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<form:errors path="pincode" cssClass="error alert alert-danger" />
							<form:input path="pincode" placeholder="PIN CODE (*)" class="form-control" />
						</div>
						
						<!-- Register Button -->
						<div style="margin-top: 10px" class="form-group">						
							<div class="col-sm-6 controls">
								<button type="submit" class="btn btn-primary">Register</button>
							</div>
						</div>
						
					</form:form>
  </div>
  </section>
    <!-- Footer -->
      <footer id="footer">
        <div class="inner">
          <h2>Get In Touch</h2>
          <ul class="actions">
            <li><span class="icon fa-phone"></span> (+91) 97825-65081</li>
            <li><span class="icon fa-envelope"></span> <a href="https://mail.google.com/mail/?view=cm&fs=1&tf=1&to=aasavbadera.cse18@iitbhu.ac.in">aasavbadera.cse18@iitbhu.ac.in</a></li>
            <li><span class="icon fa-map-marker"></span> H-2-A, Jawahar Nagar, Kota, Rajasthan</li>
          </ul>
        </div>
        <div class="copyright">
          &copy; King_01 Design <a href="https://templated.co">TEMPLATED</a>. Images <a href="https://unsplash.com">Unsplash</a>.
        </div>
      </footer>
</body>
</html>