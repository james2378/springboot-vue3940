<template>
	<el-main class="bg">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','vaccine_number') || $check_field('add','vaccine_number') || $check_field('set','vaccine_number')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="疫苗编号" prop="vaccine_number">
					<el-input id="vaccine_number" v-model="form['vaccine_number']" placeholder="请输入疫苗编号"
							  v-if="user_group === '管理员' || (form['vaccine_delivery_id'] && $check_field('set','vaccine_number')) || (!form['vaccine_delivery_id'] && $check_field('add','vaccine_number'))" :disabled="disabledObj['vaccine_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','vaccine_number')">{{form['vaccine_number']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','vaccine_type') || $check_field('add','vaccine_type') || $check_field('set','vaccine_type')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="疫苗类型" prop="vaccine_type">
					<el-input id="vaccine_type" v-model="form['vaccine_type']" placeholder="请输入疫苗类型"
							  v-if="user_group === '管理员' || (form['vaccine_delivery_id'] && $check_field('set','vaccine_type')) || (!form['vaccine_delivery_id'] && $check_field('add','vaccine_type'))" :disabled="disabledObj['vaccine_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','vaccine_type')">{{form['vaccine_type']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','vaccine_name') || $check_field('add','vaccine_name') || $check_field('set','vaccine_name')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="疫苗名称" prop="vaccine_name">
					<el-input id="vaccine_name" v-model="form['vaccine_name']" placeholder="请输入疫苗名称"
							  v-if="user_group === '管理员' || (form['vaccine_delivery_id'] && $check_field('set','vaccine_name')) || (!form['vaccine_delivery_id'] && $check_field('add','vaccine_name'))" :disabled="disabledObj['vaccine_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','vaccine_name')">{{form['vaccine_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','delivery_time') || $check_field('add','delivery_time') || $check_field('set','delivery_time')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="出库时间" prop="delivery_time">
					<el-input id="delivery_time" v-model="form['delivery_time']" placeholder="请输入出库时间"
							  v-if="user_group === '管理员' || (form['vaccine_delivery_id'] && $check_field('set','delivery_time')) || (!form['vaccine_delivery_id'] && $check_field('add','delivery_time'))" :disabled="disabledObj['delivery_time_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','delivery_time')">{{form['delivery_time']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','outbound_quantity') || $check_field('add','outbound_quantity') || $check_field('set','outbound_quantity')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="出库数量" prop="outbound_quantity">
					<el-input-number id="outbound_quantity" v-model.number="form['outbound_quantity']"
						v-if="user_group === '管理员' || (form['vaccine_delivery_id'] && $check_field('set','outbound_quantity')) || (!form['vaccine_delivery_id'] && $check_field('add','outbound_quantity'))"></el-input-number>
					<div v-else-if="$check_field('get','outbound_quantity')">{{form['outbound_quantity']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','operator') || $check_field('add','operator') || $check_field('set','operator')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="操作人" prop="operator">
					<el-input id="operator" v-model="form['operator']" placeholder="请输入操作人"
							  v-if="user_group === '管理员' || (form['vaccine_delivery_id'] && $check_field('set','operator')) || (!form['vaccine_delivery_id'] && $check_field('add','operator'))" :disabled="disabledObj['operator_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','operator')">{{form['operator']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','contact_number') || $check_field('add','contact_number') || $check_field('set','contact_number')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="联系电话" prop="contact_number">
					<el-input id="contact_number" v-model="form['contact_number']" placeholder="请输入联系电话" type="tel"
						v-if="user_group === '管理员' || (form['vaccine_delivery_id'] && $check_field('set','contact_number')) || (!form['vaccine_delivery_id'] && $check_field('add','contact_number'))">
					</el-input>
					<div v-else-if="$check_field('get','contact_number')">{{form['contact_number']}}</div>
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
				field: "vaccine_delivery_id",
				url_add: "~/api/vaccine_delivery/add?",
				url_set: "~/api/vaccine_delivery/set?",
				url_get_obj: "~/api/vaccine_delivery/get_obj?",
				url_upload: "~/api/vaccine_delivery/upload?",

				query: {
					"vaccine_delivery_id": 0,
				},

				form: {
					"vaccine_number":'', // 疫苗编号
					"vaccine_type":'', // 疫苗类型
					"vaccine_name":'', // 疫苗名称
					"delivery_time":'', // 出库时间
					"outbound_quantity":0, // 出库数量
					"operator":'', // 操作人
					"contact_number":'', // 联系电话
					"vaccine_delivery_id": 0, // ID

				},
				disabledObj:{
					"vaccine_number_isDisabled": false,
					"vaccine_type_isDisabled": false,
					"vaccine_name_isDisabled": false,
					"delivery_time_isDisabled": false,
					"operator_isDisabled": false,
					"contact_number_isDisabled": false,
				},

			}
		},
		methods: {

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
					bl = this.$check_action('/vaccine_delivery/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/vaccine_delivery/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/vaccine_delivery/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/vaccine_delivery/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/vaccine_delivery/view','get');
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
