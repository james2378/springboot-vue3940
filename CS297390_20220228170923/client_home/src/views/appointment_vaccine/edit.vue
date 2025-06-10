<template>
	<div class="diy_edit page_appointment_vaccine" id="appointment_vaccine_edit">
		<div class='warp'>
			<div class='container'>
				<div class='row'>
					<div v-if="$check_field('set','vaccine_number') || $check_field('add','vaccine_number') || $check_field('get','vaccine_number')" class="col-12 col-md-6">
						<div class="diy_title">
							<span>疫苗编号:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_vaccine_number" v-model="form['vaccine_number']" placeholder="请输入疫苗编号" v-if="(form['vaccine_number'] && $check_field('set','vaccine_number')) || (!form['vaccine_number'] && $check_field('add','vaccine_number'))"  :disabled="disabledObj['vaccine_number_isDisabled']"/>
							<span v-else-if="$check_field('get','vaccine_number')">{{ form['name_of_vaccinator'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','vaccine_type') || $check_field('add','vaccine_type') || $check_field('get','vaccine_type')" class="col-12 col-md-6">
						<div class="diy_title">
							<span>疫苗类型:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_vaccine_type" v-model="form['vaccine_type']" placeholder="请输入疫苗类型" v-if="(form['vaccine_type'] && $check_field('set','vaccine_type')) || (!form['vaccine_type'] && $check_field('add','vaccine_type'))"  :disabled="disabledObj['vaccine_type_isDisabled']"/>
							<span v-else-if="$check_field('get','vaccine_type')">{{ form['name_of_vaccinator'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','vaccine_name') || $check_field('add','vaccine_name') || $check_field('get','vaccine_name')" class="col-12 col-md-6">
						<div class="diy_title">
							<span>疫苗名称:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_vaccine_name" v-model="form['vaccine_name']" placeholder="请输入疫苗名称" v-if="(form['vaccine_name'] && $check_field('set','vaccine_name')) || (!form['vaccine_name'] && $check_field('add','vaccine_name'))"  :disabled="disabledObj['vaccine_name_isDisabled']"/>
							<span v-else-if="$check_field('get','vaccine_name')">{{ form['name_of_vaccinator'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','vaccine_batch') || $check_field('add','vaccine_batch') || $check_field('get','vaccine_batch')" class="col-12 col-md-6">
						<div class="diy_title">
							<span>疫苗批次:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_vaccine_batch" v-model="form['vaccine_batch']" placeholder="请输入疫苗批次" v-if="(form['vaccine_batch'] && $check_field('set','vaccine_batch')) || (!form['vaccine_batch'] && $check_field('add','vaccine_batch'))"  :disabled="disabledObj['vaccine_batch_isDisabled']"/>
							<span v-else-if="$check_field('get','vaccine_batch')">{{ form['name_of_vaccinator'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','name_of_vaccinator') || $check_field('add','name_of_vaccinator') || $check_field('get','name_of_vaccinator')" class="col-12 col-md-6">
						<div class="diy_title">
							<span>接种者姓名:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_name_of_vaccinator" v-model="form['name_of_vaccinator']" placeholder="请输入接种者姓名" v-if="(form['name_of_vaccinator'] && $check_field('set','name_of_vaccinator')) || (!form['name_of_vaccinator'] && $check_field('add','name_of_vaccinator'))"  :disabled="disabledObj['name_of_vaccinator_isDisabled']"/>
							<span v-else-if="$check_field('get','name_of_vaccinator')">{{ form['name_of_vaccinator'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','gender') || $check_field('add','gender') || $check_field('get','gender')" class="col-12 col-md-6">
						<div class="diy_title">
							<span>性别:
							</span>
						</div>
						<!-- 选项 -->
						<div class="diy_field diy_down">
							<select id="form_gender" v-model="form['gender']" v-if="(form['gender'] && $check_field('set','gender')) || (!form['gender'] && $check_field('add','gender'))" >
								<option v-for="o in list_gender" :value="o">
									{{o}}
								</option>
							</select>
							<span v-else-if="$check_field('get','gender')">{{ form['gender'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','age') || $check_field('add','age') || $check_field('get','age')" class="col-12 col-md-6">
						<div class="diy_title">
							<span>年龄:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_age" v-model="form['age']" placeholder="请输入年龄" v-if="(form['age'] && $check_field('set','age')) || (!form['age'] && $check_field('add','age'))"  :disabled="disabledObj['age_isDisabled']"/>
							<span v-else-if="$check_field('get','age')">{{ form['name_of_vaccinator'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','relationship') || $check_field('add','relationship') || $check_field('get','relationship')" class="col-12 col-md-6">
						<div class="diy_title">
							<span>关系:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_relationship" v-model="form['relationship']" placeholder="请输入关系" v-if="(form['relationship'] && $check_field('set','relationship')) || (!form['relationship'] && $check_field('add','relationship'))"  :disabled="disabledObj['relationship_isDisabled']"/>
							<span v-else-if="$check_field('get','relationship')">{{ form['name_of_vaccinator'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','time_of_appointment') || $check_field('add','time_of_appointment') || $check_field('get','time_of_appointment')" class="col-12 col-md-6">
						<div class="diy_title">
							<span>预约时间:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_time_of_appointment" v-model="form['time_of_appointment']" placeholder="请输入预约时间" v-if="(form['time_of_appointment'] && $check_field('set','time_of_appointment')) || (!form['time_of_appointment'] && $check_field('add','time_of_appointment'))"  :disabled="disabledObj['time_of_appointment_isDisabled']"/>
							<span v-else-if="$check_field('get','time_of_appointment')">{{ form['name_of_vaccinator'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','booking_place') || $check_field('add','booking_place') || $check_field('get','booking_place')" class="col-12 col-md-6">
						<div class="diy_title">
							<span>预约地点:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_booking_place" v-model="form['booking_place']" placeholder="请输入预约地点" v-if="(form['booking_place'] && $check_field('set','booking_place')) || (!form['booking_place'] && $check_field('add','booking_place'))"  :disabled="disabledObj['booking_place_isDisabled']"/>
							<span v-else-if="$check_field('get','booking_place')">{{ form['name_of_vaccinator'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','appointment_person') || $check_field('add','appointment_person') || $check_field('get','appointment_person')" class="col-12 col-md-6">
						<div class="diy_title">
							<span>预约人:
							</span>
						</div>
						<div class="diy_field diy_down">
							<select id="form_appointment_person" :disabled="disabledObj['appointment_person_isDisabled']" v-model="form['appointment_person']" v-if="(form['appointment_person'] && $check_field('set','appointment_person')) || (!form['appointment_person'] && $check_field('add','appointment_person'))" >
								<option v-for="o in list_user_appointment_person" :value="o['user_id']">
									{{o['nickname'] + '-' + o['username']}}
								</option>
							</select>
							<span v-else-if="$check_field('get','appointment_person')">{{ form['appointment_person'] }}</span>
						</div>
					</div>
					<div v-if="user_group === '管理员' || $check_examine()" class="col-12 col-md-6">
						<div class="diy_title">
							<span>
								审核状态:
							</span>
						</div>
						<div class="diy_field diy_select" v-if="$check_action('/appointment_vaccine/edit','examine')">
							<!--<span> {{ form['examine_state'] }} </span>-->
							<select v-model="form['examine_state']">
								<option value="未审核">
									未审核
								</option>
								<option value="已通过">
									已通过
								</option>
								<option value="未通过">
									未通过
								</option>
							</select>
						</div>
						<div class="diy_field diy_text" v-else>
							<span>
								{{ form['examine_state'] }}
							</span>
						</div>
					</div>
					<div v-if="user_group === '管理员' || $check_examine()" class="col-12 col-md-6" >
						<div class="diy_title">
							<span>
								审核回复:
							</span>
						</div>
						<div class="diy_field diy_desc" v-if="$check_action('/appointment_vaccine/edit','examine')">
							<textarea v-model="form['examine_reply']"></textarea>
						</div>
						<div class="diy_field diy_text" v-else>
							<span>
								{{ form['examine_reply'] }}
							</span>
						</div>
					</div>

				</div>
				<div class="row">
					<div class="col-12">
						<div class="btn_box">
							<button class="btn_submit" @click="submit()">提交</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import mixin from "@/mixins/page.js";
	export default {
		mixins: [mixin],
		components: {},
		data() {
			return {
				url_get_obj: "~/api/appointment_vaccine/get_obj?",
				url_add: "~/api/appointment_vaccine/add?",
				url_set: "~/api/appointment_vaccine/set?",

				// 登录权限
				oauth: {
					"signIn": true,
					"user_group": []
				},

				// 查询条件
				query: {
					"vaccine_number": "",
					"vaccine_type": "",
					"vaccine_name": "",
					"vaccine_batch": "",
					"name_of_vaccinator": "",
					"gender": "",
					"age": "",
					"relationship": "",
					"time_of_appointment": "",
					"booking_place": "",
					"appointment_person": 0,
					"appointment_vaccine_id": 0,
				},

				obj: {
					"vaccine_number":'', // 疫苗编号
					"vaccine_type":'', // 疫苗类型
					"vaccine_name":'', // 疫苗名称
					"vaccine_batch":'', // 疫苗批次
					"name_of_vaccinator":'', // 接种者姓名
					"gender":'', // 性别
					"age":'', // 年龄
					"relationship":'', // 关系
					"time_of_appointment":'', // 预约时间
					"booking_place":'', // 预约地点
					"appointment_person": 0, // 预约人
					"examine_state": "未审核",
					"examine_reply": "",
					"appointment_vaccine_id": 0,
				},

				// 表单字段
				form: {
					"vaccine_number":'', // 疫苗编号
					"vaccine_type":'', // 疫苗类型
					"vaccine_name":'', // 疫苗名称
					"vaccine_batch":'', // 疫苗批次
					"name_of_vaccinator":'', // 接种者姓名
					"gender":'', // 性别
					"age":'', // 年龄
					"relationship":'', // 关系
					"time_of_appointment":'', // 预约时间
					"booking_place":'', // 预约地点
					"appointment_person": 0, // 预约人
					"examine_state": "未审核",
					"examine_reply": "",
					"appointment_vaccine_id": 0,

				},
				disabledObj:{
					"vaccine_number_isDisabled": false,
					"vaccine_type_isDisabled": false,
					"vaccine_name_isDisabled": false,
					"vaccine_batch_isDisabled": false,
					"name_of_vaccinator_isDisabled": false,
					"gender_isDisabled": false,
					"age_isDisabled": false,
					"relationship_isDisabled": false,
					"time_of_appointment_isDisabled": false,
					"booking_place_isDisabled": false,
					"appointment_person_isDisabled": false,
				},
				//性别选项列表
				list_gender: ['男','女'],
				// 用户列表
				list_user_appointment_person: [],

				// ID字段
				field: "appointment_vaccine_id",
			}
		},
		methods: {
			/**
			 * 获取用户注册用户列表
			 */
			async get_list_user_appointment_person() {
				// if(this.user_group !== "管理员" && this.form["appointment_person"] === 0) {
				//     this.form["appointment_person"] = this.user.user_id;
				// }
				var json = await this.$get("~/api/user/get_list?user_group=用户注册");
				if(json.result && json.result.list){
					this.list_user_appointment_person = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			async get_user_session_appointment_person(){
				var _this = this;
				var json = await this.$get("~/api/user_group/get_obj?name=用户注册");
				if(json.result && json.result.obj){
					var source_table = json.result.obj.source_table;
					var user_id = _this.$store.state.user.user_id;
					if (user_id){
						var url = "~/api/"+source_table+"/get_obj?"
						this.$get(url, {"user_id":_this.$store.state.user.user_id}, function(res) {
							if (res.result && res.result.obj) {
								var arr = []
								for (let key in res.result.obj) {
									arr.push(key)
								}
								var arrForm = []
								for (let key in _this.form) {
									arrForm.push(key)
								}
								_this.form["appointment_person"] = user_id
								_this.disabledObj['appointment_person' + '_isDisabled'] = true
								for (var i=0;i<arr.length;i++){
									for (var j=0;j<arrForm.length;j++){
										if (arr[i]===arrForm[j]){
											if (arr[i]!=="appointment_person") {
												_this.form[arrForm[j]] = res.result.obj[arr[i]]
												_this.disabledObj[arrForm[j] + '_isDisabled'] = true
												break;
											}
										}
									}
								}
							}
						});
					}
				}
				else if(json.error){
					console.error(json.error);
				}
			},

			/**
			 * 修改文件
			 * @param { Object } files 上传文件对象
			 * @param { String } str 表单的属性名
			 */
			change_file(files, str) {
				var form = new FormData();
				form.append("file", files[0]);
				this.$post("~/api/appointment_vaccine/upload?", form, (res) => {
					if (res.result) {
						this.form[str] = res.result.url;
					} else if (res.error) {
						this.$toast(res.error.message);
					}
				});
			},

			/**
			 * 获取对象后获取缓存表单
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_before(param){
				var form = $.db.get("form");
				if (form) {
					this.obj = $.push(this.obj ,form);
					this.form = $.push(this.form ,form);
				}
				var arr = []
				for (let key in form) {
					arr.push(key)
				}
				for (var i=0;i<arr.length;i++){
					this.disabledObj[arr[i] + '_isDisabled'] = true
				}
				return param;
			},

			/**
			 * 获取对象后获取缓存表单
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json ,func){
				var form = $.db.get("form");
				var obj = Object.assign({} ,form ,this.obj);
				if (form) {
					this.obj = $.push(this.obj ,obj);
				}
				if (form) {
					this.form = $.push(this.form ,form);
				}
				if(func){
					func(json);
				}
			},

		},
		created() {
			this.get_user_session_appointment_person();
			this.get_list_user_appointment_person();
		}
	}
</script>

<style>
</style>
