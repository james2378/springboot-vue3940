<template>
	<el-main class="bg">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','vaccine_number') || $check_field('add','vaccine_number') || $check_field('set','vaccine_number')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="疫苗编号" prop="vaccine_number">
					<el-input id="vaccine_number" v-model="form['vaccine_number']" placeholder="请输入疫苗编号"
							  v-if="user_group === '管理员' || (form['reservation_plan_id'] && $check_field('set','vaccine_number')) || (!form['reservation_plan_id'] && $check_field('add','vaccine_number'))" :disabled="disabledObj['vaccine_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','vaccine_number')">{{form['vaccine_number']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','vaccine_type') || $check_field('add','vaccine_type') || $check_field('set','vaccine_type')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="疫苗类型" prop="vaccine_type">
					<el-input id="vaccine_type" v-model="form['vaccine_type']" placeholder="请输入疫苗类型"
							  v-if="user_group === '管理员' || (form['reservation_plan_id'] && $check_field('set','vaccine_type')) || (!form['reservation_plan_id'] && $check_field('add','vaccine_type'))" :disabled="disabledObj['vaccine_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','vaccine_type')">{{form['vaccine_type']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','vaccine_name') || $check_field('add','vaccine_name') || $check_field('set','vaccine_name')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="疫苗名称" prop="vaccine_name">
					<el-input id="vaccine_name" v-model="form['vaccine_name']" placeholder="请输入疫苗名称"
							  v-if="user_group === '管理员' || (form['reservation_plan_id'] && $check_field('set','vaccine_name')) || (!form['reservation_plan_id'] && $check_field('add','vaccine_name'))" :disabled="disabledObj['vaccine_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','vaccine_name')">{{form['vaccine_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','inoculation_time') || $check_field('add','inoculation_time') || $check_field('set','inoculation_time')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="接种时间" prop="inoculation_time">
					<el-input id="inoculation_time" v-model="form['inoculation_time']" placeholder="请输入接种时间"
							  v-if="user_group === '管理员' || (form['reservation_plan_id'] && $check_field('set','inoculation_time')) || (!form['reservation_plan_id'] && $check_field('add','inoculation_time'))" :disabled="disabledObj['inoculation_time_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','inoculation_time')">{{form['inoculation_time']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','vaccination_site') || $check_field('add','vaccination_site') || $check_field('set','vaccination_site')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="接种地点" prop="vaccination_site">
					<el-input id="vaccination_site" v-model="form['vaccination_site']" placeholder="请输入接种地点"
							  v-if="user_group === '管理员' || (form['reservation_plan_id'] && $check_field('set','vaccination_site')) || (!form['reservation_plan_id'] && $check_field('add','vaccination_site'))" :disabled="disabledObj['vaccination_site_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','vaccination_site')">{{form['vaccination_site']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','vaccine_batch') || $check_field('add','vaccine_batch') || $check_field('set','vaccine_batch')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="疫苗批次" prop="vaccine_batch">
					<el-input id="vaccine_batch" v-model="form['vaccine_batch']" placeholder="请输入疫苗批次"
							  v-if="user_group === '管理员' || (form['reservation_plan_id'] && $check_field('set','vaccine_batch')) || (!form['reservation_plan_id'] && $check_field('add','vaccine_batch'))" :disabled="disabledObj['vaccine_batch_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','vaccine_batch')">{{form['vaccine_batch']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','picture') || $check_field('add','picture') || $check_field('set','picture')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="图片" prop="picture">
					<el-upload :disabled="disabledObj['picture_isDisabled']" id="picture" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_picture"
						:show-file-list="false" v-if="user_group === '管理员' || (form['reservation_plan_id'] && $check_field('set','picture')) || (!form['reservation_plan_id'] && $check_field('add','picture'))">
						<img v-if="form['picture']" :src="$fullUrl(form['picture'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','picture')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['picture'])" :preview-src-list="[$fullUrl(form['picture'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','matters_needing_attention') || $check_field('add','matters_needing_attention') || $check_field('set','matters_needing_attention')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="注意事项" prop="matters_needing_attention">
					<el-input type="textarea" id="matters_needing_attention" v-model="form['matters_needing_attention']" placeholder="请输入注意事项"
						v-if="user_group === '管理员' || (form['reservation_plan_id'] && $check_field('set','matters_needing_attention')) || (!form['reservation_plan_id'] && $check_field('add','matters_needing_attention'))" :disabled="disabledObj['matters_needing_attention_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','matters_needing_attention')">{{form['matters_needing_attention']}}</div>
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
				field: "reservation_plan_id",
				url_add: "~/api/reservation_plan/add?",
				url_set: "~/api/reservation_plan/set?",
				url_get_obj: "~/api/reservation_plan/get_obj?",
				url_upload: "~/api/reservation_plan/upload?",

				query: {
					"reservation_plan_id": 0,
				},

				form: {
					"vaccine_number":'', // 疫苗编号
					"vaccine_type":'', // 疫苗类型
					"vaccine_name":'', // 疫苗名称
					"inoculation_time":'', // 接种时间
					"vaccination_site":'', // 接种地点
					"vaccine_batch":'', // 疫苗批次
					"picture":'', // 图片
					"matters_needing_attention":'', // 注意事项
					"reservation_plan_id": 0, // ID

				},
				disabledObj:{
					"vaccine_number_isDisabled": false,
					"vaccine_type_isDisabled": false,
					"vaccine_name_isDisabled": false,
					"inoculation_time_isDisabled": false,
					"vaccination_site_isDisabled": false,
					"vaccine_batch_isDisabled": false,
					"picture_isDisabled": false,
					"matters_needing_attention_isDisabled": false,
				},

			}
		},
		methods: {
			/**
			 * 上传图片
			 * @param {Object} param图片参数
			 */
			upload_picture(param){
				this.uploadFile(param.file, "picture");
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
					bl = this.$check_action('/reservation_plan/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/reservation_plan/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/reservation_plan/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/reservation_plan/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/reservation_plan/view','get');
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
