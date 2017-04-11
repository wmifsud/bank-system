--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: account; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE account (
    accountid integer NOT NULL,
    balance double precision,
    datecreated timestamp with time zone,
    type character varying(10),
    clientaccountid bigint
);


ALTER TABLE account OWNER TO postgres;

--
-- Name: account_accountid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE account_accountid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE account_accountid_seq OWNER TO postgres;

--
-- Name: account_accountid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE account_accountid_seq OWNED BY account.accountid;


--
-- Name: address; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE address (
    addressid integer NOT NULL,
    addressline1 character varying,
    addressline2 character varying,
    city character varying,
    country character varying
);


ALTER TABLE address OWNER TO postgres;

--
-- Name: address_addressid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE address_addressid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE address_addressid_seq OWNER TO postgres;

--
-- Name: address_addressid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE address_addressid_seq OWNED BY address.addressid;


--
-- Name: client; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE client (
    clientid integer NOT NULL,
    name character varying,
    surname character varying,
    primaryaddressid bigint,
    secondaryaddressid bigint
);


ALTER TABLE client OWNER TO postgres;

--
-- Name: client_clientid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE client_clientid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE client_clientid_seq OWNER TO postgres;

--
-- Name: client_clientid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE client_clientid_seq OWNED BY client.clientid;


--
-- Name: transaction; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE transaction (
    transactionid integer NOT NULL,
    debitaccountid bigint,
    creditaccountid bigint,
    amount double precision,
    message character varying,
    datecreated timestamp with time zone
);


ALTER TABLE transaction OWNER TO postgres;

--
-- Name: transaction_transactionid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE transaction_transactionid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE transaction_transactionid_seq OWNER TO postgres;

--
-- Name: transaction_transactionid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE transaction_transactionid_seq OWNED BY transaction.transactionid;


--
-- Name: account accountid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY account ALTER COLUMN accountid SET DEFAULT nextval('account_accountid_seq'::regclass);


--
-- Name: address addressid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY address ALTER COLUMN addressid SET DEFAULT nextval('address_addressid_seq'::regclass);


--
-- Name: client clientid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY client ALTER COLUMN clientid SET DEFAULT nextval('client_clientid_seq'::regclass);


--
-- Name: transaction transactionid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY transaction ALTER COLUMN transactionid SET DEFAULT nextval('transaction_transactionid_seq'::regclass);


--
-- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY account (accountid, balance, datecreated, type, clientaccountid) FROM stdin;
24	100	2015-10-24 00:00:00+02	SAVINGS	36
25	100	2015-10-24 00:00:00+02	SAVINGS	36
26	100	2015-10-24 00:00:00+02	SAVINGS	36
27	100	2015-10-24 00:00:00+02	SAVINGS	36
28	100	2015-10-24 00:00:00+02	SAVINGS	36
29	100	2015-10-24 00:00:00+02	SAVINGS	36
30	100	2015-10-24 00:00:00+02	SAVINGS	36
31	100	2015-10-24 00:00:00+02	SAVINGS	36
32	100	2015-10-24 00:00:00+02	SAVINGS	36
33	100	2015-10-24 00:00:00+02	SAVINGS	36
34	100	2015-10-24 00:00:00+02	SAVINGS	36
35	100	2015-10-24 00:00:00+02	SAVINGS	36
36	100	2015-10-24 00:00:00+02	SAVINGS	36
37	100	2015-10-24 00:00:00+02	SAVINGS	36
38	100.239999999999995	2015-10-24 00:00:00+02	SAVINGS	36
39	100	2015-10-24 00:00:00+02	SAVINGS	36
40	100	2015-10-24 00:00:00+02	SAVINGS	36
41	100	2015-10-24 00:00:00+02	SAVINGS	36
42	100	2015-10-24 00:00:00+02	SAVINGS	36
43	100	2015-10-24 00:00:00+02	SAVINGS	36
45	100	2015-10-25 00:00:00+02	SAVINGS	36
48	100	2015-10-25 00:00:00+02	SAVINGS	36
49	100	2015-10-25 06:33:49+01	SAVINGS	36
50	100	2015-10-25 08:27:54+01	SAVINGS	36
51	100	2015-10-31 01:28:27+01	SAVINGS	36
52	100	2015-10-25 08:28:59+01	SAVINGS	36
53	100	2015-10-25 08:31:01+01	SAVINGS	36
57	100	2015-10-25 07:51:02.218+01	SAVINGS	36
58	100	2015-10-25 07:52:33.979+01	SAVINGS	36
59	100	2015-10-25 07:52:59.098+01	SAVINGS	36
60	100	2015-10-25 07:53:32.055+01	SAVINGS	36
61	100	2015-10-25 07:59:13.064+01	SAVINGS	36
62	100	2015-10-25 08:02:00.942+01	SAVINGS	36
63	100	2015-10-25 08:05:19.87+01	SAVINGS	36
64	100	2015-10-25 08:06:15.46+01	SAVINGS	36
94	100	2015-10-25 10:36:39.741+01	SAVINGS	101
95	-100	2015-10-25 10:36:39.741+01	CURRENT	101
96	100	2015-10-25 10:36:40.503+01	SAVINGS	36
114	100	2015-10-25 12:11:28.581+01	SAVINGS	36
65	100	2015-10-25 08:07:19.01+01	SAVINGS	36
66	100	2015-10-25 08:07:54.687+01	SAVINGS	36
67	100	2015-10-25 08:19:13.944+01	SAVINGS	36
68	100	2015-10-25 08:19:38.843+01	SAVINGS	36
69	100	2015-10-25 08:20:51.713+01	SAVINGS	36
70	100	2015-10-25 08:21:39.378+01	SAVINGS	36
71	100	2015-10-25 08:22:51.691+01	SAVINGS	36
72	100	2015-10-25 08:22:55.568+01	SAVINGS	36
124	100	2015-10-25 12:35:06.001+01	SAVINGS	121
73	100	2015-10-25 08:27:25.433+01	SAVINGS	36
97	100	2015-10-25 10:42:07.241+01	SAVINGS	103
98	-100	2015-10-25 10:42:07.241+01	CURRENT	103
99	100	2015-10-25 10:42:08.122+01	SAVINGS	36
125	-100	2015-10-25 12:35:06.001+01	CURRENT	121
76	100	2015-10-25 08:59:41.391+01	SAVINGS	36
77	100	2015-10-25 09:11:28.747+01	SAVINGS	91
78	-100	2015-10-25 09:11:28.747+01	CURRENT	91
79	100	2015-10-25 09:22:20.832+01	SAVINGS	92
80	-100	2015-10-25 09:22:20.832+01	CURRENT	92
81	100	2015-10-25 09:36:17.528+01	SAVINGS	93
82	-100	2015-10-25 09:36:17.528+01	CURRENT	93
83	100	2015-10-25 09:36:18.315+01	SAVINGS	36
100	100	2015-10-25 10:56:47.973+01	SAVINGS	105
85	-100	2015-10-25 09:49:27.055+01	CURRENT	95
86	101	2015-10-25 10:01:27.293+01	SAVINGS	96
87	-100	2015-10-25 10:01:27.293+01	CURRENT	96
101	-100	2015-10-25 10:56:47.973+01	CURRENT	105
102	100	2015-10-25 10:56:48.747+01	SAVINGS	36
115	100	2015-10-25 12:15:20.944+01	SAVINGS	115
103	100	2015-10-25 11:23:54.757+01	SAVINGS	107
104	-100	2015-10-25 11:23:54.757+01	CURRENT	107
105	100	2015-10-25 11:23:55.613+01	SAVINGS	36
116	-100	2015-10-25 12:15:20.944+01	CURRENT	115
117	100	2015-10-25 12:15:21.921+01	SAVINGS	36
88	100	2015-10-25 10:12:49.898+01	SAVINGS	97
89	-100	2015-10-25 10:12:49.898+01	CURRENT	97
90	100	2015-10-25 10:12:50.681+01	SAVINGS	36
106	100	2015-10-25 12:01:56.051+01	SAVINGS	109
91	100	2015-10-25 10:30:51.703+01	SAVINGS	99
92	-100	2015-10-25 10:30:51.703+01	CURRENT	99
93	100	2015-10-25 10:30:52.472+01	SAVINGS	36
126	100	2015-10-25 12:35:07.028+01	SAVINGS	36
130	100	2015-10-25 12:41:48.79+01	SAVINGS	125
107	-100	2015-10-25 12:01:56.051+01	CURRENT	109
108	100	2015-10-25 12:01:56.838+01	SAVINGS	36
109	100	2015-10-25 12:06:48.93+01	SAVINGS	111
110	-100	2015-10-25 12:06:48.931+01	CURRENT	111
111	100	2015-10-25 12:06:49.835+01	SAVINGS	36
131	-100	2015-10-25 12:41:48.79+01	CURRENT	125
112	100	2015-10-25 12:11:27.66+01	SAVINGS	113
113	-100	2015-10-25 12:11:27.66+01	CURRENT	113
118	100	2015-10-25 12:17:15.261+01	SAVINGS	117
119	-100	2015-10-25 12:17:15.262+01	CURRENT	117
120	100	2015-10-25 12:17:16.133+01	SAVINGS	36
127	100	2015-10-25 12:40:07.68+01	SAVINGS	123
121	100	2015-10-25 12:19:04.371+01	SAVINGS	119
122	-100	2015-10-25 12:19:04.371+01	CURRENT	119
123	100	2015-10-25 12:19:05.326+01	SAVINGS	36
132	100	2015-10-25 12:41:49.698+01	SAVINGS	36
141	100	2015-10-25 12:56:21.004+01	SAVINGS	132
128	-100	2015-10-25 12:40:07.68+01	CURRENT	123
129	100	2015-10-25 12:40:08.549+01	SAVINGS	36
133	100	2015-10-25 12:44:46.992+01	SAVINGS	127
134	-100	2015-10-25 12:44:46.992+01	CURRENT	127
136	100	2015-10-25 12:50:58.168+01	SAVINGS	129
135	100	2015-10-25 12:44:47.864+01	SAVINGS	36
144	100	2015-10-25 15:08:01.161+01	SAVINGS	134
137	-100	2015-10-25 12:50:58.168+01	CURRENT	129
138	100	2015-10-25 12:50:59.064+01	SAVINGS	36
139	100	2015-10-25 12:55:26.614+01	SAVINGS	131
140	-100	2015-10-25 12:55:26.614+01	CURRENT	131
142	-100	2015-10-25 12:56:21.005+01	CURRENT	132
143	100	2015-10-25 12:56:21.94+01	SAVINGS	36
74	3760.10000000000218	2015-10-25 08:28:43.025+01	SAVINGS	36
145	-100	2015-10-25 15:08:01.161+01	CURRENT	134
146	100	2015-10-25 15:08:02.095+01	SAVINGS	36
147	100	2015-10-25 15:11:07.029+01	SAVINGS	136
148	-100	2015-10-25 15:11:07.029+01	CURRENT	136
149	100	2015-10-25 15:11:07.953+01	SAVINGS	36
150	100	2015-10-25 15:15:25.247+01	SAVINGS	138
151	-100	2015-10-25 15:15:25.247+01	CURRENT	138
152	100	2015-10-25 15:15:26.158+01	SAVINGS	36
153	100	2015-10-25 15:30:48.303+01	SAVINGS	140
154	-100	2015-10-25 15:30:48.303+01	CURRENT	140
155	100	2015-10-25 15:30:49.352+01	SAVINGS	36
156	100	2015-10-25 15:33:16.74+01	SAVINGS	142
157	-100	2015-10-25 15:33:16.74+01	CURRENT	142
158	100	2015-10-25 15:33:17.741+01	SAVINGS	36
159	100	2015-10-25 15:35:25.475+01	SAVINGS	144
160	-100	2015-10-25 15:35:25.475+01	CURRENT	144
161	100	2015-10-25 15:35:26.579+01	SAVINGS	36
162	100	2015-10-25 15:37:28.394+01	SAVINGS	146
163	-100	2015-10-25 15:37:28.395+01	CURRENT	146
164	100	2015-10-25 15:37:29.422+01	SAVINGS	36
165	100	2015-10-25 15:40:30.044+01	SAVINGS	148
166	-100	2015-10-25 15:40:30.044+01	CURRENT	148
167	100	2015-10-25 15:40:31.285+01	SAVINGS	36
168	100	2015-10-25 15:47:23.408+01	SAVINGS	150
169	-100	2015-10-25 15:47:23.408+01	CURRENT	150
170	100	2015-10-25 15:47:24.386+01	SAVINGS	36
171	100	2015-10-25 15:57:01.081+01	SAVINGS	152
172	-100	2015-10-25 15:57:01.081+01	CURRENT	152
173	100	2015-10-25 15:57:02.112+01	SAVINGS	36
174	100	2015-10-25 16:02:26.666+01	SAVINGS	154
175	-100	2015-10-25 16:02:26.666+01	CURRENT	154
176	100	2015-10-25 16:02:27.771+01	SAVINGS	36
177	100	2015-10-25 16:07:01.293+01	SAVINGS	36
178	100	2015-10-25 16:07:32.432+01	SAVINGS	36
179	100	2015-10-25 16:21:26.144+01	SAVINGS	158
180	-100	2015-10-25 16:21:26.144+01	CURRENT	158
181	100	2015-10-25 16:21:27.149+01	SAVINGS	36
182	100	2015-10-25 16:33:55.276+01	SAVINGS	160
183	-100	2015-10-25 16:33:55.276+01	CURRENT	160
184	100	2015-10-25 16:33:56.698+01	SAVINGS	36
185	100	2015-10-25 17:06:35.448+01	SAVINGS	162
186	-100	2015-10-25 17:06:35.448+01	CURRENT	162
187	100	2015-10-25 17:06:36.659+01	SAVINGS	36
75	-3560.10000000000173	2015-10-25 08:30:53.291+01	SAVINGS	36
188	100	2015-10-25 17:13:03.264+01	SAVINGS	164
189	-100	2015-10-25 17:13:03.264+01	CURRENT	164
190	100	2015-10-25 17:13:04.522+01	SAVINGS	36
\.


--
-- Name: account_accountid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('account_accountid_seq', 190, true);


--
-- Data for Name: address; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY address (addressid, addressline1, addressline2, city, country) FROM stdin;
49	Triq	Skuna	Qawra	Malta
50	Pioneer	Road	London	England
51	Triq	Skuna	Qawra	Malta
52	Pioneer	Road	London	England
53	Triq	Skuna	Qawra	Malta
54	Pioneer	Road	London	England
55	Triq	Skuna	Qawra	Malta
56	Pioneer	Road	London	England
57	Triq	Skuna	Qawra	Malta
58	Pioneer	Road	London	England
59	Triq	Skuna	Qawra	Malta
60	Pioneer	Road	London	England
61	Triq	Skuna	Qawra	Malta
62	Pioneer	Road	London	England
63	Triq	Skuna	Qawra	Malta
64	Pioneer	Road	London	England
65	Triq	Skuna	Qawra	Malta
66	Pioneer	Road	London	England
67	Triq	Skuna	Qawra	Malta
68	Pioneer	Road	London	England
69	Triq	Skuna	Qawra	Malta
70	Pioneer	Road	London	England
71	Triq	Skuna	Qawra	Malta
72	Pioneer	Road	London	England
73	Triq	Skuna	Qawra	Malta
74	Pioneer	Road	London	England
75	Triq	Skuna	Qawra	Malta
76	Pioneer	Road	London	England
77	Triq	Skuna	Qawra	Malta
78	Pioneer	Road	London	England
79	Triq	Skuna	Qawra	Malta
80	Pioneer	Road	London	England
81	Triq	Skuna	Qawra	Malta
82	Pioneer	Road	London	England
83	Triq	Skuna	Qawra	Malta
84	Pioneer	Road	London	England
85	Triq	Skuna	Qawra	Malta
86	Pioneer	Road	London	England
87	Pioneer	Road	London	England
88	Pioneer	Road	London	England
89	Pioneer	Road	London	England
90	Pioneer	Road	London	England
91	Pioneer	Road	London	England
92	Pioneer	Road	London	England
93	Pioneer	Road	London	England
94	Pioneer	Road	London	England
95	Pioneer	Road	London	England
96	Triq	Skuna	Qawra	Malta
97	Pioneer	Road	London	England
98	Pioneer	Road	London	England
99	Pioneer	Road	London	England
100	Pioneer	Road	London	England
101	Pioneer	Road	London	England
102	Pioneer	Road	London	England
103	Pioneer	Road	London	England
118	Triq	Skuna	Qawra	Malta
119	Pioneer	Road	London	England
120	Triq	Skuna	Qawra	Malta
121	Pioneer	Road	London	England
122	Triq	Skuna	Qawra	Malta
123	Pioneer	Road	London	England
124	Triq	Skuna	Qawra	Malta
125	Pioneer	Road	London	England
126	Triq	Skuna	Qawra	Malta
127	Pioneer	Road	London	England
130	Triq	Skuna	Qawra	Malta
131	Pioneer	Road	London	England
132	Triq	Skuna	Qawra	Malta
133	Pioneer	Road	London	England
134	Triq	Skuna	Qawra	Malta
135	Pioneer	Road	London	England
136	Triq	Skuna	Qawra	Malta
137	Pioneer	Road	London	England
138	Triq	Skuna	Qawra	Malta
139	Pioneer	Road	London	England
140	Triq	Skuna	Qawra	Malta
141	Pioneer	Road	London	England
142	Triq	Skuna	Qawra	Malta
143	Pioneer	Road	London	England
144	Triq	Skuna	Qawra	Malta
145	Pioneer	Road	London	England
146	Triq	Skuna	Qawra	Malta
147	Pioneer	Road	London	England
148	Triq	Skuna	Qawra	Malta
149	Pioneer	Road	London	England
150	Triq	Skuna	Qawra	Malta
151	Pioneer	Road	London	England
152	Triq	Skuna	Qawra	Malta
153	Pioneer	Road	London	England
154	Triq	Skuna	Qawra	Malta
155	Pioneer	Road	London	England
156	Triq	Skuna	Qawra	Malta
157	Pioneer	Road	London	England
158	Triq	Skuna	Qawra	Malta
159	Pioneer	Road	London	England
160	Triq	Skuna	Qawra	Malta
161	Pioneer	Road	London	England
162	Triq	Skuna	Qawra	Malta
163	Pioneer	Road	London	England
164	Triq	Skuna	Qawra	Malta
165	Pioneer	Road	London	England
166	Triq	Skuna	Qawra	Malta
167	Pioneer	Road	London	England
168	Triq	Skuna	Qawra	Malta
169	Pioneer	Road	London	England
170	Triq	Skuna	Qawra	Malta
171	Pioneer	Road	London	England
172	Triq	Skuna	Qawra	Malta
173	Pioneer	Road	London	England
174	Triq	Skuna	Qawra	Malta
175	Pioneer	Road	London	England
176	Triq	Skuna	Qawra	Malta
177	Pioneer	Road	London	England
178	Triq	Skuna	Qawra	Malta
179	Pioneer	Road	London	England
180	Triq	Skuna	Qawra	Malta
181	Pioneer	Road	London	England
182	Triq	Skuna	Qawra	Malta
183	Pioneer	Road	London	England
184	Triq	Skuna	Qawra	Malta
185	Pioneer	Road	London	England
186	Triq	Skuna	Qawra	Malta
187	Pioneer	Road	London	England
188	Triq	Skuna	Qawra	Malta
189	Pioneer	Road	London	England
190	Triq	Skuna	Qawra	Malta
191	Pioneer	Road	London	England
192	Triq	Skuna	Qawra	Malta
193	Pioneer	Road	London	England
194	Triq	Skuna	Qawra	Malta
195	Pioneer	Road	London	England
196	Triq	Skuna	Qawra	Malta
197	Pioneer	Road	London	England
198	Triq	Skuna	Qawra	Malta
199	Pioneer	Road	London	England
200	Triq	Skuna	Qawra	Malta
201	Pioneer	Road	London	England
202	Triq	Skuna	Qawra	Malta
203	Pioneer	Road	London	England
204	Triq	Skuna	Qawra	Malta
205	Pioneer	Road	London	England
206	Triq	Skuna	Qawra	Malta
207	Pioneer	Road	London	England
208	Triq	Skuna	Qawra	Malta
209	Pioneer	Road	London	England
210	Triq	Skuna	Qawra	Malta
211	Pioneer	Road	London	England
212	Triq	Skuna	Qawra	Malta
213	Pioneer	Road	London	England
214	Triq	Skuna	Qawra	Malta
215	Pioneer	Road	London	England
216	Triq	Skuna	Qawra	Malta
217	Pioneer	Road	London	England
218	Triq	Skuna	Qawra	Malta
219	Pioneer	Road	London	England
220	Triq	Skuna	Qawra	Malta
221	Pioneer	Road	London	England
222	Triq	Skuna	Qawra	Malta
223	Pioneer	Road	London	England
224	Triq	Skuna	Qawra	Malta
225	Pioneer	Road	London	England
226	Triq	Skuna	Qawra	Malta
227	Pioneer	Road	London	England
228	Triq	Skuna	Qawra	Malta
229	Pioneer	Road	London	England
230	Triq	Skuna	Qawra	Malta
231	Pioneer	Road	London	England
232	Triq	Skuna	Qawra	Malta
233	Pioneer	Road	London	England
234	Triq	Skuna	Qawra	Malta
235	Pioneer	Road	London	England
236	Triq	Skuna	Qawra	Malta
237	Pioneer	Road	London	England
238	Triq	Skuna	Qawra	Malta
239	Pioneer	Road	London	England
240	Triq	Skuna	Qawra	Malta
241	Pioneer	Road	London	England
242	Triq	Skuna	Qawra	Malta
243	Pioneer	Road	London	England
244	Triq	Skuna	Qawra	Malta
245	Pioneer	Road	London	England
246	Triq	Skuna	Qawra	Malta
247	Pioneer	Road	London	England
248	Triq	Skuna	Qawra	Malta
249	Pioneer	Road	London	England
250	Triq	Skuna	Qawra	Malta
251	Pioneer	Road	London	England
252	Triq	Skuna	Qawra	Malta
253	Pioneer	Road	London	England
254	Triq	Skuna	Qawra	Malta
255	Pioneer	Road	London	England
256	Triq	Skuna	Qawra	Malta
257	Pioneer	Road	London	England
258	Triq	Skuna	Qawra	Malta
259	Pioneer	Road	London	England
260	Triq	Skuna	Qawra	Malta
261	Pioneer	Road	London	England
262	Triq	Skuna	Qawra	Malta
263	Pioneer	Road	London	England
264	Triq	Skuna	Qawra	Malta
265	Pioneer	Road	London	England
266	Triq	Skuna	Qawra	Malta
267	Pioneer	Road	London	England
268	Triq	Skuna	Qawra	Malta
269	Pioneer	Road	London	England
270	Triq	Skuna	Qawra	Malta
271	Pioneer	Road	London	England
272	Triq	Skuna	Qawra	Malta
273	Pioneer	Road	London	England
274	Triq	Skuna	Qawra	Malta
275	Pioneer	Road	London	England
276	Triq	Skuna	Qawra	Malta
277	Pioneer	Road	London	England
278	Triq	Skuna	Qawra	Malta
279	Pioneer	Road	London	England
280	Triq	Skuna	Qawra	Malta
281	Pioneer	Road	London	England
282	Triq	Skuna	Qawra	Malta
283	Pioneer	Road	London	England
284	Triq	Skuna	Qawra	Malta
285	Pioneer	Road	London	England
286	Triq	Skuna	Qawra	Malta
287	Pioneer	Road	London	England
288	Triq	Skuna	Qawra	Malta
289	Pioneer	Road	London	England
290	Triq	Skuna	Qawra	Malta
291	Pioneer	Road	London	England
292	Triq	Skuna	Qawra	Malta
293	Pioneer	Road	London	England
294	Triq	Skuna	Qawra	Malta
295	Pioneer	Road	London	England
296	Triq	Skuna	Qawra	Malta
297	Pioneer	Road	London	England
298	Triq	Skuna	Qawra	Malta
299	Pioneer	Road	London	England
\.


--
-- Name: address_addressid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('address_addressid_seq', 299, true);


--
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY client (clientid, name, surname, primaryaddressid, secondaryaddressid) FROM stdin;
33	waylon	mifsud	49	50
34	waylon	mifsud	51	52
35	waylon	mifsud	53	54
36	waylon	mifsud	55	56
37	waylon	mifsud	57	58
38	waylon	mifsud	59	60
39	waylon	mifsud	61	62
40	waylon	mifsud	63	64
42	waylon	mifsud	67	68
43	waylon	mifsud	69	70
44	waylon	mifsud	71	72
61	waylon	mifsud	96	97
75	waylon	mifsud	118	119
76	waylon	mifsud	120	121
77	waylon	mifsud	122	123
78	waylon	mifsud	124	125
79	waylon	mifsud	126	127
81	waylon	mifsud	130	131
82	waylon	mifsud	132	133
83	waylon	mifsud	134	135
84	waylon	mifsud	136	137
85	waylon	mifsud	138	139
86	waylon	mifsud	140	141
87	waylon	mifsud	142	143
88	waylon	mifsud	144	145
89	waylon	mifsud	146	147
90	waylon	mifsud	148	149
91	waylon	mifsud	150	151
92	waylon	mifsud	152	153
93	waylon	mifsud	154	155
94	waylon	mifsud	156	157
95	waylon	mifsud	158	159
96	waylon	mifsud	160	161
97	waylon	mifsud	162	163
98	waylon	mifsud	164	165
99	waylon	mifsud	166	167
100	waylon	mifsud	168	169
101	waylon	mifsud	170	171
102	waylon	mifsud	172	173
103	waylon	mifsud	174	175
104	waylon	mifsud	176	177
105	waylon	mifsud	178	179
106	waylon	mifsud	180	181
107	waylon	mifsud	182	183
108	waylon	mifsud	184	185
109	waylon	mifsud	186	187
110	waylon	mifsud	188	189
111	waylon	mifsud	190	191
112	waylon	mifsud	192	193
113	waylon	mifsud	194	195
114	waylon	mifsud	196	197
115	waylon	mifsud	198	199
116	waylon	mifsud	200	201
117	waylon	mifsud	202	203
118	waylon	mifsud	204	205
119	waylon	mifsud	206	207
120	waylon	mifsud	208	209
121	waylon	mifsud	210	211
122	waylon	mifsud	212	213
123	waylon	mifsud	214	215
124	waylon	mifsud	216	217
125	waylon	mifsud	218	219
126	waylon	mifsud	220	221
127	waylon	mifsud	222	223
128	waylon	mifsud	224	225
129	waylon	mifsud	226	227
130	waylon	mifsud	228	229
131	waylon	mifsud	230	231
132	waylon	mifsud	232	233
133	waylon	mifsud	234	235
134	waylon	mifsud	236	237
135	waylon	mifsud	238	239
136	waylon	mifsud	240	241
137	waylon	mifsud	242	243
138	waylon	mifsud	244	245
139	waylon	mifsud	246	247
140	waylon	mifsud	248	249
141	waylon	mifsud	250	251
142	waylon	mifsud	252	253
143	waylon	mifsud	254	255
144	waylon	mifsud	256	257
145	waylon	mifsud	258	259
146	waylon	mifsud	260	261
147	waylon	mifsud	262	263
148	waylon	mifsud	264	265
149	waylon	mifsud	266	267
150	waylon	mifsud	268	269
151	waylon	mifsud	270	271
152	waylon	mifsud	272	273
153	waylon	mifsud	274	275
154	waylon	mifsud	276	277
155	waylon	mifsud	278	279
156	waylon	mifsud	280	281
157	waylon	mifsud	282	283
158	waylon	mifsud	284	285
159	waylon	mifsud	286	287
160	waylon	mifsud	288	289
161	waylon	mifsud	290	291
162	waylon	mifsud	292	293
163	waylon	mifsud	294	295
164	waylon	mifsud	296	297
165	waylon	mifsud	298	299
\.


--
-- Name: client_clientid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('client_clientid_seq', 165, true);


--
-- Data for Name: transaction; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY transaction (transactionid, debitaccountid, creditaccountid, amount, message, datecreated) FROM stdin;
8	20	22	100	transfer between accounts	2015-10-25 08:06:53.927+01
9	20	22	100	transfer between accounts	2015-10-25 08:07:17.75+01
10	20	22	100	transfer between accounts	2015-10-25 08:27:24.294+01
11	20	22	100	transfer between accounts	2015-10-25 08:28:41.808+01
12	20	22	100	transfer between accounts	2015-10-25 08:30:52.176+01
13	20	22	100	transfer between accounts	2015-10-25 08:59:40.307+01
14	20	22	100	transfer between accounts	2015-10-25 09:36:17.196+01
15	20	22	107.650000000000006	transfer between accounts	2015-10-25 10:03:30.704+01
16	20	22	107.650000000000006	transfer between accounts	2015-10-25 10:04:57.745+01
17	20	22	107.650000000000006	transfer between accounts	2015-10-25 10:07:06.524+01
18	20	22	0.0500000000000000028	transfer between accounts	2015-10-25 10:07:43.249+01
19	20	22	107.650000000000006	transfer between accounts	2015-10-25 10:08:28.967+01
20	75	74	107.650000000000006	transfer between accounts	2015-10-25 10:12:49.555+01
21	75	74	107.650000000000006	transfer between accounts	2015-10-25 10:30:51.362+01
22	75	74	107.650000000000006	transfer between accounts	2015-10-25 10:36:39.417+01
23	75	74	107.650000000000006	transfer between accounts	2015-10-25 10:42:06.855+01
24	75	74	107.650000000000006	transfer between accounts	2015-10-25 10:56:47.639+01
25	75	74	107.650000000000006	transfer between accounts	2015-10-25 11:23:54.427+01
26	75	74	107.650000000000006	transfer between accounts	2015-10-25 12:01:55.632+01
27	75	74	107.650000000000006	transfer between accounts	2015-10-25 12:06:48.571+01
28	75	74	107.650000000000006	transfer between accounts	2015-10-25 12:11:27.202+01
29	75	74	107.650000000000006	transfer between accounts	2015-10-25 12:15:20.577+01
30	75	74	107.650000000000006	transfer between accounts	2015-10-25 12:17:14.916+01
31	75	74	107.650000000000006	transfer between accounts	2015-10-25 12:19:04.009+01
32	75	74	107.650000000000006	transfer between accounts	2015-10-25 12:35:05.631+01
33	75	74	107.650000000000006	transfer between accounts	2015-10-25 12:40:07.339+01
34	75	74	107.650000000000006	transfer between accounts	2015-10-25 12:41:48.451+01
35	75	74	107.650000000000006	transfer between accounts	2015-10-25 12:44:46.673+01
36	75	74	107.650000000000006	transfer between accounts	2015-10-25 12:50:57.79+01
37	75	74	107.650000000000006	transfer between accounts	2015-10-25 12:56:20.682+01
38	75	74	107.650000000000006	transfer between accounts	2015-10-25 15:08:00.821+01
39	75	74	107.650000000000006	transfer between accounts	2015-10-25 15:11:06.694+01
40	75	74	107.650000000000006	transfer between accounts	2015-10-25 15:15:24.912+01
41	75	74	107.650000000000006	transfer between accounts	2015-10-25 15:30:47.938+01
42	75	74	107.650000000000006	transfer between accounts	2015-10-25 15:33:16.424+01
43	75	74	107.650000000000006	transfer between accounts	2015-10-25 15:35:25.13+01
44	75	74	107.650000000000006	transfer between accounts	2015-10-25 15:37:28.05+01
45	75	74	107.650000000000006	transfer between accounts	2015-10-25 15:40:29.582+01
46	75	74	107.650000000000006	transfer between accounts	2015-10-25 15:47:23.081+01
47	75	74	107.650000000000006	transfer between accounts	2015-10-25 15:57:00.715+01
48	75	74	107.650000000000006	transfer between accounts	2015-10-25 16:02:26.326+01
49	75	74	107.650000000000006	transfer between accounts	2015-10-25 16:13:40.68+01
50	75	74	107.650000000000006	transfer between accounts	2015-10-25 16:21:25.824+01
51	75	74	107.650000000000006	transfer between accounts	2015-10-25 16:33:54.816+01
52	75	74	107.650000000000006	transfer between accounts	2015-10-25 17:06:35.102+01
53	75	74	107.650000000000006	transfer between accounts	2015-10-25 17:13:02.893+01
\.


--
-- Name: transaction_transactionid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('transaction_transactionid_seq', 53, true);


--
-- Name: account account_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY account
    ADD CONSTRAINT account_pkey PRIMARY KEY (accountid);


--
-- Name: address address_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY address
    ADD CONSTRAINT address_pkey PRIMARY KEY (addressid);


--
-- Name: client client_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY client
    ADD CONSTRAINT client_pkey PRIMARY KEY (clientid);


--
-- Name: transaction transactionid_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY transaction
    ADD CONSTRAINT transactionid_pkey PRIMARY KEY (transactionid);


--
-- Name: account clientaccountid; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY account
    ADD CONSTRAINT clientaccountid FOREIGN KEY (clientaccountid) REFERENCES client(clientid);


--
-- Name: client primaryaddressid; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY client
    ADD CONSTRAINT primaryaddressid FOREIGN KEY (primaryaddressid) REFERENCES address(addressid);


--
-- Name: client secondaryaddressid; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY client
    ADD CONSTRAINT secondaryaddressid FOREIGN KEY (secondaryaddressid) REFERENCES address(addressid);


--
-- Name: public; Type: ACL; Schema: -; Owner: waylon
--

GRANT ALL ON SCHEMA public TO postgres;


--
-- PostgreSQL database dump complete
--

