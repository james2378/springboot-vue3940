<template>
	<el-main class="bg">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','vaccine_number') || $check_field('add','vaccine_number') || $check_field('set','vaccine_number')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="疫苗编号" prop="vaccine_number">
					<el-input id="vaccine_number" v-model="form['vaccine_number']" placeholder="请输入疫苗编号"
							  v-if="user_group === '管理员' || (form['vaccination_record_id'] && $check_field('set','vaccine_number')) || (!form['vaccination_record_id'] && $check_field('add','vaccine_number'))" :disabled="disabledObj['vaccine_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','vaccine_number')">{{form['vaccine_number']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','vaccine_type') || $check_field('add','vaccine_type') || $check_field('set','vaccine_type')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="疫苗类型" prop="vaccine_type">
					<el-input id="vaccine_type" v-model="form['vaccine_type']" placeholder="请输入疫苗类型"
							  v-if="user_group === '管理员' || (form['vaccination_record_id'] && $check_field('set','vaccine_type')) || (!form['vaccination_record_id'] && $check_field('add','vaccine_type'))" :disabled="disabledObj['vaccine_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','vaccine_type')">{{form['vaccine_type']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','vaccine_name') || $check_field('add','vaccine_name') || $check_field('set','vaccine_name')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="疫苗名称" prop="vaccine_name">
					<el-input id="vaccine_name" v-model="form['vaccine_name']" placeholder="请输入疫苗名称"
							  v-if="user_group === '管理员' || (form['vaccination_record_id'] && $check_field('set','vaccine_name')) || (!form['vaccination_record_id'] && $check_field('add','vaccine_name'))" :disabled="disabledObj['vaccine_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','vaccine_name')">{{form['vaccine_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','vaccine_batch') || $check_field('add','vaccine_batch') || $check_field('set','vaccine_batch')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="疫苗批次" prop="vaccine_batch">
					<el-input id="vaccine_batch" v-model="form['vaccine_batch']" placeholder="请输入疫苗批次"
							  v-if="user_group === '管理员' || (form['vaccination_record_id'] && $check_field('set','vaccine_batch')) || (!form['vaccination_record_id'] && $check_field('add','vaccine_batch'))" :disabled="disabledObj['vaccine_batch_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','vaccine_batch')">{{form['vaccine_batch']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','name_of_vaccinator') || $check_field('add','name_of_vaccinator') || $check_field('set','name_of_vaccinator')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="接种者姓名" prop="name_of_vaccinator">
					<el-input id="name_of_vaccinator" v-model="form['name_of_vaccinator']" placeholder="请输入接种者姓名"
							  v-if="user_group === '管理员' || (form['vaccination_record_id'] && $check_field('set','name_of_vaccinator')) || (!form['vaccination_record_id'] && $check_field('add','name_of_vaccinator'))" :disabled="disabledObj['name_of_vaccinator_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','name_of_vaccinator')">{{form['name_of_vaccinator']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','gender') || $check_field('add','gender') || $check_field('set','gender')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="性别" prop="gender">
					<el-input id="gender" v-model="form['gender']" placeholder="请输入性别"
							  v-if="user_group === '管理员' || (form['vaccination_record_id'] && $check_field('set','gender')) || (!form['vaccination_record_id'] && $check_field('add','gender'))" :disabled="disabledObj['gender_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','gender')">{{form['gender']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','age') || $check_field('add','age') || $check_field('set','age')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="年龄" prop="age">
					<el-input id="age" v-model="form['age']" placeholder="请输入年龄"
							  v-if="user_group === '管理员' || (form['vaccination_record_id'] && $check_field('set','age')) || (!form['vaccination_record_id'] && $check_field('add','age'))" :disabled="disabledObj['age_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','age')">{{form['age']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','relationship') || $check_field('add','relationship') || $check_field('set','relationship')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="关系" prop="relationship">
					<el-input id="relationship" v-model="form['relationship']" placeholder="请输入关系"
							  v-if="user_group === '管理员' || (form['vaccination_record_id'] && $check_field('set','relationship')) || (!form['vaccination_record_id'] && $check_field('add','relationship'))" :disabled="disabledObj['relationship_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','relationship')">{{form['relationship']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','appointment_person') || $check_field('add','appointment_person') || $check_field('set','appointment_person')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="预约人" prop="appointment_person">
						<el-select v-if="user_group === '管理员' || (form['vaccination_record_id'] && $check_field('set','appointment_person')) || (!form['vaccination_record_id'] && $check_field('add','appointment_person'))" id="appointment_person" v-model="form['appointment_person']" :disabled="disabledObj['appointment_person_isDisabled']">
							<el-option v-for="o in list_user_appointment_person" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','appointment_person')" id="appointment_person" v-model="form['appointment_person']" :disabled="true">
							<el-option v-for="o in list_user_appointment_person" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','inoculation_time') || $check_field('add','inoculation_time') || $check_field('set','inoculation_time')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="接种时间" prop="inoculation_time">
					<el-input id="inoculation_time" v-model="form['inoculation_time']" placeholder="请输入接种时间"
							  v-if="user_group === '管理员' || (form['vaccination_record_id'] && $check_field('set','inoculation_time')) || (!form['vaccination_record_id'] && $check_field('add','inoculation_time'))" :disabled="disabledObj['inoculation_time_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','inoculation_time')">{{form['inoculation_time']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','vaccination_site') || $check_field('add','vaccination_site') || $check_field('set','vaccination_site')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="接种地点" prop="vaccination_site">
					<el-input id="vaccination_site" v-model="form['vaccination_site']" placeholder="请输入接种地点"
							  v-if="user_group === '管理员' || (form['vaccination_record_id'] && $check_field('set','vaccination_site')) || (!form['vaccination_record_id'] && $check_field('add','vaccination_site'))" :disabled="disabledObj['vaccination_site_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','vaccination_site')">{{form['vaccination_site']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','observation_time') || $check_field('add','observation_time') || $check_field('set','observation_time')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="留观时间" prop="observation_time">
					<el-input id="observation_time" v-model="form['observation_time']" placeholder="请输入留观时间"
							  v-if="user_group === '管理员' || (form['vaccination_record_id'] && $check_field('set','observation_time')) || (!form['vaccination_record_id'] && $check_field('add','observation_time'))" :disabled="disabledObj['observation_time_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','observation_time')">{{form['observation_time']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','vaccination_status') || $check_field('add','vaccination_status') || $check_field('set','vaccination_status')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="接种情况" prop="vaccination_status">
					<el-input type="textarea" id="vaccination_status" v-model="form['vaccination_status']" placeholder="请输入接种情况"
						v-if="user_group === '管理员' || (form['vaccination_record_id'] && $check_field('set','vaccination_status')) || (!form['vaccination_record_id'] && $check_field('add','vaccination_status'))" :disabled="disabledObj['vaccination_status_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','vaccination_status')">{{form['vaccination_status']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','contraindication') || $check_field('add','contraindication') || $check_field('set','contraindication')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="禁忌症" prop="contraindication">
					<el-input type="textarea" id="contraindication" v-model="form['contraindication']" placeholder="请输入禁忌症"
						v-if="user_group === '管理员' || (form['vaccination_record_id'] && $check_field('set','contraindication')) || (!form['vaccination_record_id'] && $check_field('add','contraindication'))" :disabled="disabledObj['contraindication_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','contraindication')">{{form['contraindication']}}</div>
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
				field: "vaccination_record_id",
				url_add: "~/api/vaccination_record/add?",
				url_set: "~/api/vaccination_record/set?",
				url_get_obj: "~/api/vaccination_record/get_obj?",
				url_upload: "~/api/vaccination_record/upload?",

				query: {
					"vaccination_record_id": 0,
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
					"appointment_person": 0, // 预约人
					"inoculation_time":'', // 接种时间
					"vaccination_site":'', // 接种地点
					"observation_time":'', // 留观时间
					"vaccination_status":'', // 接种情况
					"contraindication":'', // 禁忌症
					"vaccination_record_id": 0, // ID

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
					"appointment_person_isDisabled": false,
					"inoculation_time_isDisabled": false,
					"vaccination_site_isDisabled": false,
					"observation_time_isDisabled": false,
					"vaccination_status_isDisabled": false,
					"contraindication_isDisabled": false,
				},
				// 用户列表
				list_user_appointment_person: [],

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
					bl = this.$check_action('/vaccination_record/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/vaccination_record/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/vaccination_record/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/vaccination_record/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/vaccination_record/view','get');
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
