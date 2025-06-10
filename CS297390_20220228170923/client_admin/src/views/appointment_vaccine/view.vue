<template>
	<el-main class="bg">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','vaccine_number') || $check_field('add','vaccine_number') || $check_field('set','vaccine_number')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="疫苗编号" prop="vaccine_number">
					<el-input id="vaccine_number" v-model="form['vaccine_number']" placeholder="请输入疫苗编号"
							  v-if="user_group === '管理员' || (form['appointment_vaccine_id'] && $check_field('set','vaccine_number')) || (!form['appointment_vaccine_id'] && $check_field('add','vaccine_number'))" :disabled="disabledObj['vaccine_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','vaccine_number')">{{form['vaccine_number']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','vaccine_type') || $check_field('add','vaccine_type') || $check_field('set','vaccine_type')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="疫苗类型" prop="vaccine_type">
					<el-input id="vaccine_type" v-model="form['vaccine_type']" placeholder="请输入疫苗类型"
							  v-if="user_group === '管理员' || (form['appointment_vaccine_id'] && $check_field('set','vaccine_type')) || (!form['appointment_vaccine_id'] && $check_field('add','vaccine_type'))" :disabled="disabledObj['vaccine_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','vaccine_type')">{{form['vaccine_type']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','vaccine_name') || $check_field('add','vaccine_name') || $check_field('set','vaccine_name')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="疫苗名称" prop="vaccine_name">
					<el-input id="vaccine_name" v-model="form['vaccine_name']" placeholder="请输入疫苗名称"
							  v-if="user_group === '管理员' || (form['appointment_vaccine_id'] && $check_field('set','vaccine_name')) || (!form['appointment_vaccine_id'] && $check_field('add','vaccine_name'))" :disabled="disabledObj['vaccine_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','vaccine_name')">{{form['vaccine_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','vaccine_batch') || $check_field('add','vaccine_batch') || $check_field('set','vaccine_batch')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="疫苗批次" prop="vaccine_batch">
					<el-input id="vaccine_batch" v-model="form['vaccine_batch']" placeholder="请输入疫苗批次"
							  v-if="user_group === '管理员' || (form['appointment_vaccine_id'] && $check_field('set','vaccine_batch')) || (!form['appointment_vaccine_id'] && $check_field('add','vaccine_batch'))" :disabled="disabledObj['vaccine_batch_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','vaccine_batch')">{{form['vaccine_batch']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','name_of_vaccinator') || $check_field('add','name_of_vaccinator') || $check_field('set','name_of_vaccinator')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="接种者姓名" prop="name_of_vaccinator">
					<el-input id="name_of_vaccinator" v-model="form['name_of_vaccinator']" placeholder="请输入接种者姓名"
							  v-if="user_group === '管理员' || (form['appointment_vaccine_id'] && $check_field('set','name_of_vaccinator')) || (!form['appointment_vaccine_id'] && $check_field('add','name_of_vaccinator'))" :disabled="disabledObj['name_of_vaccinator_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','name_of_vaccinator')">{{form['name_of_vaccinator']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','gender') || $check_field('add','gender') || $check_field('set','gender')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="性别" prop="gender">
					<el-select id="gender" v-model="form['gender']"
						v-if="user_group === '管理员' || (form['appointment_vaccine_id'] && $check_field('set','gender')) || (!form['appointment_vaccine_id'] && $check_field('add','gender'))">
						<el-option v-for="o in list_gender" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','gender')">{{form['gender']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','age') || $check_field('add','age') || $check_field('set','age')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="年龄" prop="age">
					<el-input id="age" v-model="form['age']" placeholder="请输入年龄"
							  v-if="user_group === '管理员' || (form['appointment_vaccine_id'] && $check_field('set','age')) || (!form['appointment_vaccine_id'] && $check_field('add','age'))" :disabled="disabledObj['age_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','age')">{{form['age']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','relationship') || $check_field('add','relationship') || $check_field('set','relationship')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="关系" prop="relationship">
					<el-input id="relationship" v-model="form['relationship']" placeholder="请输入关系"
							  v-if="user_group === '管理员' || (form['appointment_vaccine_id'] && $check_field('set','relationship')) || (!form['appointment_vaccine_id'] && $check_field('add','relationship'))" :disabled="disabledObj['relationship_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','relationship')">{{form['relationship']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','time_of_appointment') || $check_field('add','time_of_appointment') || $check_field('set','time_of_appointment')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="预约时间" prop="time_of_appointment">
					<el-input id="time_of_appointment" v-model="form['time_of_appointment']" placeholder="请输入预约时间"
							  v-if="user_group === '管理员' || (form['appointment_vaccine_id'] && $check_field('set','time_of_appointment')) || (!form['appointment_vaccine_id'] && $check_field('add','time_of_appointment'))" :disabled="disabledObj['time_of_appointment_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','time_of_appointment')">{{form['time_of_appointment']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','booking_place') || $check_field('add','booking_place') || $check_field('set','booking_place')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="预约地点" prop="booking_place">
					<el-input id="booking_place" v-model="form['booking_place']" placeholder="请输入预约地点"
							  v-if="user_group === '管理员' || (form['appointment_vaccine_id'] && $check_field('set','booking_place')) || (!form['appointment_vaccine_id'] && $check_field('add','booking_place'))" :disabled="disabledObj['booking_place_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','booking_place')">{{form['booking_place']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','appointment_person') || $check_field('add','appointment_person') || $check_field('set','appointment_person')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="预约人" prop="appointment_person">
						<div v-if="user_group !== '管理员'">
							{{ get_user_session_appointment_person(form['appointment_person']) }}
							<!--<el-input id="business_name" v-model="form['appointment_person']" placeholder="请输入预约人"-->
							<!--v-if="user_group === '管理员' || (form['appointment_vaccine_id'] && $check_field('set','appointment_person')) || (!form['appointment_vaccine_id'] && $check_field('add','appointment_person'))" :disabled="disabledObj['appointment_person_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','appointment_person')">{{form['appointment_person']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['appointment_vaccine_id'] && $check_field('set','appointment_person')) || (!form['appointment_vaccine_id'] && $check_field('add','appointment_person'))" id="appointment_person" v-model="form['appointment_person']" :disabled="disabledObj['appointment_person_isDisabled']">
								<el-option v-for="o in list_user_appointment_person" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','appointment_person')" id="appointment_person" v-model="form['appointment_person']" :disabled="true">
								<el-option v-for="o in list_user_appointment_person" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="appointment_person" v-model="form['appointment_person']" :disabled="disabledObj['appointment_person_isDisabled']">
							<el-option v-for="o in list_user_appointment_person" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
				</el-form-item>
			</el-col>
			<el-col :xs="24" :sm="12" :lg="8">
				<el-form-item label="审核状态" prop="examine_state">
					<el-select id="examine_state" v-model="form['examine_state']"
						v-if="user_group === '管理员' || (form['examine_state'] && $check_examine()) || (!form['examine_state'] && $check_examine())">
						<el-option key="未审核" label="未审核" value="未审核"></el-option>
						<el-option key="已通过" label="已通过" value="已通过"></el-option>
						<el-option key="未通过" label="未通过" value="未通过"></el-option>
					</el-select>
					<div v-else-if="$check_field('get','examine_state')">{{form["examine_state"]}}</div>
				</el-form-item>
			</el-col>
			<el-col :xs="24" :sm="12" :lg="8">
				<el-form-item label="审核回复" prop="examine_reply">
					<el-input id="examine_reply" v-model="form['examine_reply']" placeholder="请输入审核回复"
						v-if="user_group === '管理员' || (form['examine_reply'] && $check_examine()) || (!form['examine_reply'] && $check_examine())"></el-input>
					<div v-else-if="$check_field('get','examine_reply')">{{form["examine_reply"]}}</div>
				</el-form-item>
			</el-col>
			<el-col :xs="24" :sm="12" :lg="8">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "appointment_vaccine_id",
				url_add: "~/api/appointment_vaccine/add?",
				url_set: "~/api/appointment_vaccine/set?",
				url_get_obj: "~/api/appointment_vaccine/get_obj?",
				url_upload: "~/api/appointment_vaccine/upload?",

				query: {
					"appointment_vaccine_id": 0,
				},

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
					"appointment_vaccine_id": 0, // ID

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
				// 用户组
				group_user_appointment_person: "",

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
			/**
			 * 获取用户注册用户组
			 */
			async get_group_user_appointment_person() {
				this.form["appointment_person"] = this.user.user_id;
				var json = await this.$get("~/api/user_group/get_obj?name=用户注册");
				if(json.result && json.result.obj){
					this.group_user_appointment_person = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_appointment_person(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_appointment_person.source_table+"/get_obj?"
				this.$get(url, user_id, function(res) {
					if (res.result && res.result.obj) {
						var arr = []
						for (let key in res.result.obj) {
							arr.push(key)
						}
						var arrForm = []
						for (let key in _this.form) {
							arrForm.push(key)
						}
						for (var i=0;i<arr.length;i++){
							for (var j=0;j<arrForm.length;j++){
								if (arr[i]===arrForm[j]){
									if (arr[i]!=="appointment_person") {
										_this.form[arrForm[j]] = res.result.obj[arr[i]]
										_this.disabledObj[arrForm[j] + '_isDisabled'] = true
										break;
									}else {
										_this.disabledObj[arrForm[j] + '_isDisabled'] = true
									}
								}
							}
						}
					}
				});
			},
			get_user_appointment_person(id){
				var obj = this.list_user_appointment_person.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},

			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
				// 获取缓存数据附加
				form = $.db.get("form");
				$.push(this.form ,form);
				/**
				* 请求列表前
				* @param {Object} param
				*/
				var user_group = this.user.user_group;
				if (user_group !== "管理员") {
					switch (user_group) {
						case "预约人":
							if(param["appointment_person"] > 0){
								param["appointment_person"] = this.user.user_id;
							}
							break;
					}
				}
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							if(dbKey === "charging_standard"){
								this.form['charging_rules'] = form[dbKey];
								this.disabledObj['charging_rules_isDisabled'] = true;
							};
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
				$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){

			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/appointment_vaccine/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/appointment_vaccine/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/appointment_vaccine/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/appointment_vaccine/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/appointment_vaccine/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
			this.get_list_user_appointment_person();
			this.get_group_user_appointment_person();
		}
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}
</style>
