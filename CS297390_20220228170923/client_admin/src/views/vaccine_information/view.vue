<template>
	<el-main class="bg">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','vaccine_number') || $check_field('add','vaccine_number') || $check_field('set','vaccine_number')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="疫苗编号" prop="vaccine_number">
					<el-input id="vaccine_number" v-model="form['vaccine_number']" placeholder="请输入疫苗编号"
							  v-if="user_group === '管理员' || (form['vaccine_information_id'] && $check_field('set','vaccine_number')) || (!form['vaccine_information_id'] && $check_field('add','vaccine_number'))" :disabled="disabledObj['vaccine_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','vaccine_number')">{{form['vaccine_number']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','vaccine_type') || $check_field('add','vaccine_type') || $check_field('set','vaccine_type')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="疫苗类型" prop="vaccine_type">
					<el-input id="vaccine_type" v-model="form['vaccine_type']" placeholder="请输入疫苗类型"
							  v-if="user_group === '管理员' || (form['vaccine_information_id'] && $check_field('set','vaccine_type')) || (!form['vaccine_information_id'] && $check_field('add','vaccine_type'))" :disabled="disabledObj['vaccine_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','vaccine_type')">{{form['vaccine_type']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','vaccine_name') || $check_field('add','vaccine_name') || $check_field('set','vaccine_name')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="疫苗名称" prop="vaccine_name">
					<el-input id="vaccine_name" v-model="form['vaccine_name']" placeholder="请输入疫苗名称"
							  v-if="user_group === '管理员' || (form['vaccine_information_id'] && $check_field('set','vaccine_name')) || (!form['vaccine_information_id'] && $check_field('add','vaccine_name'))" :disabled="disabledObj['vaccine_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','vaccine_name')">{{form['vaccine_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','suitable_for_people') || $check_field('add','suitable_for_people') || $check_field('set','suitable_for_people')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="适合人群" prop="suitable_for_people">
					<el-input id="suitable_for_people" v-model="form['suitable_for_people']" placeholder="请输入适合人群"
							  v-if="user_group === '管理员' || (form['vaccine_information_id'] && $check_field('set','suitable_for_people')) || (!form['vaccine_information_id'] && $check_field('add','suitable_for_people'))" :disabled="disabledObj['suitable_for_people_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','suitable_for_people')">{{form['suitable_for_people']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','vaccine_producing_area') || $check_field('add','vaccine_producing_area') || $check_field('set','vaccine_producing_area')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="疫苗出产地" prop="vaccine_producing_area">
					<el-select id="vaccine_producing_area" v-model="form['vaccine_producing_area']"
						v-if="user_group === '管理员' || (form['vaccine_information_id'] && $check_field('set','vaccine_producing_area')) || (!form['vaccine_information_id'] && $check_field('add','vaccine_producing_area'))">
						<el-option v-for="o in list_vaccine_producing_area" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','vaccine_producing_area')">{{form['vaccine_producing_area']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','picture') || $check_field('add','picture') || $check_field('set','picture')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="图片" prop="picture">
					<el-upload :disabled="disabledObj['picture_isDisabled']" id="picture" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_picture"
						:show-file-list="false" v-if="user_group === '管理员' || (form['vaccine_information_id'] && $check_field('set','picture')) || (!form['vaccine_information_id'] && $check_field('add','picture'))">
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
			<el-col v-if="user_group === '管理员' || $check_field('get','stock') || $check_field('add','stock') || $check_field('set','stock')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="库存" prop="stock">
					<el-input-number id="stock" v-model.number="form['stock']"
						v-if="user_group === '管理员' || (form['vaccine_information_id'] && $check_field('set','stock')) || (!form['vaccine_information_id'] && $check_field('add','stock'))"></el-input-number>
					<div v-else-if="$check_field('get','stock')">{{form['stock']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','vaccine_introduction') || $check_field('add','vaccine_introduction') || $check_field('set','vaccine_introduction')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="疫苗简介" prop="vaccine_introduction">
					<el-input type="textarea" id="vaccine_introduction" v-model="form['vaccine_introduction']" placeholder="请输入疫苗简介"
						v-if="user_group === '管理员' || (form['vaccine_information_id'] && $check_field('set','vaccine_introduction')) || (!form['vaccine_information_id'] && $check_field('add','vaccine_introduction'))" :disabled="disabledObj['vaccine_introduction_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','vaccine_introduction')">{{form['vaccine_introduction']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','side_effect') || $check_field('add','side_effect') || $check_field('set','side_effect')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="副作用" prop="side_effect">
					<el-input type="textarea" id="side_effect" v-model="form['side_effect']" placeholder="请输入副作用"
						v-if="user_group === '管理员' || (form['vaccine_information_id'] && $check_field('set','side_effect')) || (!form['vaccine_information_id'] && $check_field('add','side_effect'))" :disabled="disabledObj['side_effect_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','side_effect')">{{form['side_effect']}}</div>
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
				field: "vaccine_information_id",
				url_add: "~/api/vaccine_information/add?",
				url_set: "~/api/vaccine_information/set?",
				url_get_obj: "~/api/vaccine_information/get_obj?",
				url_upload: "~/api/vaccine_information/upload?",

				query: {
					"vaccine_information_id": 0,
				},

				form: {
					"vaccine_number":'', // 疫苗编号
					"vaccine_type":'', // 疫苗类型
					"vaccine_name":'', // 疫苗名称
					"suitable_for_people":'', // 适合人群
					"vaccine_producing_area":'', // 疫苗出产地
					"picture":'', // 图片
					"stock":0, // 库存
					"vaccine_introduction":'', // 疫苗简介
					"side_effect":'', // 副作用
					"vaccine_information_id": 0, // ID

				},
				disabledObj:{
					"vaccine_number_isDisabled": false,
					"vaccine_type_isDisabled": false,
					"vaccine_name_isDisabled": false,
					"suitable_for_people_isDisabled": false,
					"vaccine_producing_area_isDisabled": false,
					"picture_isDisabled": false,
					"vaccine_introduction_isDisabled": false,
					"side_effect_isDisabled": false,
				},
				//疫苗出产地选项列表
				list_vaccine_producing_area: ['进口','国产'],

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
					bl = this.$check_action('/vaccine_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/vaccine_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/vaccine_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/vaccine_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/vaccine_information/view','get');
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
